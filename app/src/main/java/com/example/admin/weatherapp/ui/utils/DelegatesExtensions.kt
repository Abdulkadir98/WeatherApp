package com.example.admin.weatherapp.ui.utils

import android.content.Context
import kotlin.reflect.KProperty

/**
 * Created by admin on 11/29/2018.
 */

object DelegateExt {
    fun longPreference(context: Context, name: String, default: Long) =
            LongPreference(context, name, default)
}
class LongPreference(val context: Context, val name: String, val default: Long) {

    val prefs by lazy {
        context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long {
         return prefs.getLong(name, default)
    }

     operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
         prefs.edit().putLong(name, value).apply()
     }

}