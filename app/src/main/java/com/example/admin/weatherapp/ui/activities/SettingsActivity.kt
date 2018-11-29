package com.example.admin.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.admin.weatherapp.R
import com.example.admin.weatherapp.ui.utils.DelegateExt
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.toolbar.*

class SettingsActivity : AppCompatActivity() {

    companion object {
        val ZIP_CODE = "zipCode"
        val DEFAULT_ZIP =94043L
    }

    var zipCode: Long by DelegateExt.longPreference(this, ZIP_CODE, DEFAULT_ZIP)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        cityCode.setText(zipCode.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when(item?.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> false
    }

    override fun onBackPressed() {
        super.onBackPressed()
        zipCode = cityCode.text.toString().toLong()
    }
}
