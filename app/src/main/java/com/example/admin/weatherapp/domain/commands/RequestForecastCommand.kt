package com.example.admin.weatherapp.domain.commands

import com.example.admin.weatherapp.data.ForecastRequest
import com.example.admin.weatherapp.domain.mapper.ForecastDataMapper
import com.example.admin.weatherapp.domain.model.ForecastList

/**
 * Created by admin on 11/2/2018.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val requestForecast = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(requestForecast.execute())
    }

}