package com.example.admin.weatherapp.data.db

import com.example.admin.weatherapp.domain.datasource.ForecastDataSource
import com.example.admin.weatherapp.domain.model.ForecastList
import com.example.admin.weatherapp.ui.utils.clear
import com.example.admin.weatherapp.ui.utils.parseList
import com.example.admin.weatherapp.ui.utils.parseOpt
import com.example.admin.weatherapp.ui.utils.toVarargArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by admin on 11/13/2018.
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {
    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?  = forecastDbHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.Name)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dataMapper.convertToDomain(city) else null
    }


    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {
        clear(CityForecastTable.Name)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.Name, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }
}