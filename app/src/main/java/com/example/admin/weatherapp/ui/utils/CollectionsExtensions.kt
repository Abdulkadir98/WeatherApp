package com.example.admin.weatherapp.ui.utils

/**
 * Created by admin on 11/13/2018.
 */
fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()