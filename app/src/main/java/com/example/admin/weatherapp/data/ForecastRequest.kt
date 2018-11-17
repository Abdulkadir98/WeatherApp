package com.example.admin.weatherapp.data

import com.example.admin.weatherapp.data.server.ForecastResult
import com.google.gson.Gson

/**
 * Created by admin on 10/28/2018.
 */
class ForecastRequest(val zipCode: String) {

    // implements static behavior as in java, shared by all instances of ForecastRequest
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q=94043&mode=json&units=metric&cnt=7"

    }

    val jsonString = "{\"city\":{\"id\":5375480,\"name\":\"Mountain View\",\"coord\":{\"lon\":-122.0833" +
            ",\"lat\":37.3894},\"country\":\"US\",\"population\":74066},\"cod\":\"200\",\"message\":3.094175" +
            ",\"cnt\":7,\"list\":[{\"dt\":1541790000,\"temp\":{\"day\":10.82,\"min\":5.35,\"max\":10.82," +
            "\"night\":5.35,\"eve\":10.82,\"morn\":10.82},\"pressure\":994.58,\"humidity\":65,\"weather\"" +
            ":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01n\"}],\"speed\"" +
            ":1.56,\"deg\":338,\"clouds\":0},{\"dt\":1541876400,\"temp\":{\"day\":15.19,\"min\":0.02,\"max\"" +
            ":19,\"night\":2.7,\"eve\":17.15,\"morn\":1.02},\"pressure\":993,\"humidity\":36,\"weather\"" +
            ":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}]," +
            "\"speed\":1.26,\"deg\":101,\"clouds\":0},{\"dt\":1541962800,\"temp\":{\"day\":13.93," +
            "\"min\":-1.32,\"max\":17.95,\"night\":1.81,\"eve\":16.79,\"morn\":-0.63},\"pressure\"" +
            ":994.08,\"humidity\":42,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":" +
            "\"sky is clear\",\"icon\":\"01d\"}],\"speed\":1.43,\"deg\":22,\"clouds\":0},{\"dt\"" +
            ":1542049200,\"temp\":{\"day\":14.42,\"min\":6,\"max\":16.7,\"night\":8.46,\"eve\":16.7" +
            ",\"morn\":6},\"pressure\":1019.19,\"humidity\":0,\"weather\":[{\"id\":800,\"main\"" +
            ":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":2.08,\"deg\"" +
            ":61,\"clouds\":0},{\"dt\":1542135600,\"temp\":{\"day\":13.95,\"min\":6.99,\"max\":15.77" +
            ",\"night\":6.99,\"eve\":15.77,\"morn\":7.7},\"pressure\":1022.82,\"humidity\":0," +
            "\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\"" +
            ":\"04d\"}],\"speed\":2.53,\"deg\":62,\"clouds\":66},{\"dt\":1542222000,\"temp\":{\"day" +
            "\":13.14,\"min\":5,\"max\":15.64,\"night\":6.96,\"eve\":15.64,\"morn\":5},\"pressure\"" +
            ":1019.21,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":" +
            "\"sky is clear\",\"icon\":\"01d\"}],\"speed\":2.14,\"deg\":10,\"clouds\":0},{\"dt\"" +
            ":1542308400,\"temp\":{\"day\":11.91,\"min\":5.64,\"max\":15.2,\"night\":7.57,\"eve\"" +
            ":15.2,\"morn\":5.64},\"pressure\":1014.72,\"humidity\":0,\"weather\":[{\"id\":500," +
            "\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":1.2," +
            "\"deg\":32,\"clouds\":22}]}"

    fun execute(): ForecastResult {
        val forecastJsonStr = java.net.URL(COMPLETE_URL).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}