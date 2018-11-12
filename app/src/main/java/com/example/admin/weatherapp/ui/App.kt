package com.example.admin.weatherapp.ui

import android.app.Application

/**
 * Created by admin on 11/12/2018.
 */
class App: Application() {

    companion object {
        lateinit var instance: App
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}