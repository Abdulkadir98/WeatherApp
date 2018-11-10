package com.example.admin.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.admin.weatherapp.R
import com.example.admin.weatherapp.domain.model.Forecast
import com.example.admin.weatherapp.domain.model.ForecastList
import com.example.admin.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by admin on 10/25/2018.
 */
//The second property of the class is a lambda function (functions is kotlin are first-class citizens
// They can be passed as values to other fns, can returned from functions and stored in a variable
//left side of the arrow is the input parameter and the right side is the return type of the function
//it is synonymous to function declaration
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    private val TAG: String = ForecastListAdapter::class.java.simpleName

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        Log.d(TAG, "size: ${weekForecast.size}")
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //with takes an object and an extension function as paramters
        //makes the object execute the function
        //Useful for several operations on the same object
        holder.bindForecast(weekForecast[position])
    }

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) :
            RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTempView = view.find<TextView>(R.id.maxTemperature)
        private val minTempView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.get().load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTempView.text = "$high"
                minTempView.text = "$low"

                // if the last argument in a function is a function then it can be moved out of the parantheses
                // if the function is the only argument then the parantheses can be removed
                itemView.setOnClickListener { itemClick(this) }
            }
        }


    }

//    interface OnItemClickListener {
//        operator fun invoke(forecast: Forecast)
//    }
}

