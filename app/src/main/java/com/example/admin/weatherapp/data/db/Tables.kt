package com.example.admin.weatherapp.data.db

/**
 * Created by admin on 11/12/2018.
 */
object CityForecastTable {
    val Name = "CityForecast"
    val ID = "_id"
    val COUNTRY = "country"
    val CITY = "city"
}

object DayForecastTable {
    val NAME = "DayForecast"
    val ID = "_id"
    val DATE = "date"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val ICON_URL = "iconUrl"
    val CITY_ID = "cityId"
}