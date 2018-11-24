package com.example.admin.weatherapp.domain.datasource

import com.example.admin.weatherapp.domain.model.Forecast
import com.example.admin.weatherapp.domain.model.ForecastList

/**
 * Created by admin on 11/17/2018.
 */
interface ForecastDataSource  {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
    fun requestDayForecast(id: Long) : Forecast?
}