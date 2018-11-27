package com.example.admin.weatherapp.ui.utils

import android.content.Context
import android.view.View

/**
 * Created by admin on 11/7/2018.
 */
val View.ctx : Context
    get() = context

fun View.slideExit() {
     if (translationY == 0f) animate().translationY(-height.toFloat())
     }

fun View.slideEnter() {
     if (translationY < 0f) animate().translationY(0f)
     }