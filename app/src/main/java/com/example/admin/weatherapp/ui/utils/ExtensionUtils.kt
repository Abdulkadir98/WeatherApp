package com.example.admin.weatherapp.ui.utils

import java.text.DateFormat
import java.util.*

/**
 * Created by admin on 11/21/2018.
 */

fun Long.toDateString(dateFormat : Int = DateFormat.MEDIUM) : String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}