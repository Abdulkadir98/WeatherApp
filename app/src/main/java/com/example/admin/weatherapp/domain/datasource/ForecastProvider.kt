package com.example.admin.weatherapp.domain.datasource

import com.example.admin.weatherapp.data.db.ForecastDb
import com.example.admin.weatherapp.data.server.ForecastServer
import com.example.admin.weatherapp.domain.model.ForecastList
import com.example.admin.weatherapp.ui.utils.firstResult

/**
 * Created by admin on 11/17/2018.
 */
class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val SOURCES = listOf(ForecastDb(), ForecastServer())
        val DAY_IN_MILLIS = 1000*60*60*24
    }

    fun requestByZipCode(zipCode: Long, days: Int) : ForecastList = sources.firstResult{
        requestSource(it, days, zipCode) }
    private fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size >= days) res else null
    }
    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

}