package com.example.admin.weatherapp.domain.commands

import com.example.admin.weatherapp.domain.datasource.ForecastProvider
import com.example.admin.weatherapp.domain.model.ForecastList

/**
 * Created by admin on 11/2/2018.
 */
class RequestForecastCommand(private val zipCode: Long,
                             private val forecastProvider: ForecastProvider = ForecastProvider()) :
                                Command<ForecastList> {

    companion object {
        val DAYS = 7
    }
    override fun execute(): ForecastList  = forecastProvider.requestByZipCode(zipCode, DAYS)
}