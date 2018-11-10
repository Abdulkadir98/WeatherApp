package com.example.admin.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.admin.weatherapp.R
import com.example.admin.weatherapp.domain.commands.RequestForecastCommand
import com.example.admin.weatherapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    val items = listOf("Mon 6/23 - Sunny - 31/17",
                        "Mon 6/23 - Sunny - 31/17",
                        "Mon 6/23 - Sunny - 31/17",
                        "Mon 6/23 - Sunny - 31/17",
                        "Mon 6/23 - Sunny - 31/17",
                        "Mon 6/23 - Sunny - 31/17")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)



        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                // functions definitions are passed in curly braces
               forecastList.adapter = ForecastListAdapter(result) {

                   // if there's only one argument then the left side of the arrow can be removed
                   // and the 'it' specifier provided by kotlin is used.
                   toast(it.date)
               }
            }
        }

    }
}