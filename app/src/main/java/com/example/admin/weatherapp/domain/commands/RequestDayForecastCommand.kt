package com.example.admin.weatherapp.domain.commands

import com.example.admin.weatherapp.domain.datasource.ForecastProvider
import com.example.admin.weatherapp.domain.model.Forecast

/**
 * Created by admin on 11/21/2018.
 */
class RequestDayForecastCommand(val id: Long,
                                val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {
    override fun execute(): Forecast  = forecastProvider.requestForecast(id)

}