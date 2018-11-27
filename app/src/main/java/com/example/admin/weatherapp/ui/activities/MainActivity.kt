package com.example.admin.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.example.admin.weatherapp.R
import com.example.admin.weatherapp.domain.commands.RequestForecastCommand
import com.example.admin.weatherapp.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), ToolbarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)



        doAsync {
            val result = RequestForecastCommand(94043).execute()
            uiThread {
                // functions definitions are passed in curly braces
               forecastList.adapter = ForecastListAdapter(result) {

                   // if there's only one argument then the left side of the arrow can be removed
                   // and the 'it' specifier provided by kotlin is used.
//                   toast(it.date.toString())
                   startActivity<DetailActivity>(DetailActivity.ID to it.id,
                           DetailActivity.CITY_NAME to result.city)
               }
                toolbarTitle = "${result.city} (${result.country})"
            }
        }

    }
}
