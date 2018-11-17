package com.example.admin.weatherapp.data.server

import com.example.admin.weatherapp.data.db.ForecastDb
import com.example.admin.weatherapp.domain.datasource.ForecastDataSource
import com.example.admin.weatherapp.domain.model.ForecastList

/**
 * Created by admin on 11/17/2018.
 */
class ForecastServer(private val dataMapper: ServerDataMapper = ServerDataMapper(),
                     private val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {
    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)    }

}