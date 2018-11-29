package com.example.admin.weatherapp.ui.activities

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.example.admin.weatherapp.R
import com.example.admin.weatherapp.ui.App
import com.example.admin.weatherapp.ui.utils.ctx
import com.example.admin.weatherapp.ui.utils.slideEnter
import com.example.admin.weatherapp.ui.utils.slideExit
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by admin on 11/27/2018.
 */
interface ToolbarManager {
    val toolbar: Toolbar

    var toolbarTitle: String
    get() = toolbar.title.toString()
    set(value) {
        toolbar.title = value
    }

    fun initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_settings -> toolbar.ctx.startActivity<SettingsActivity>()
                else -> App.instance.toast(" Unknown option")
            }
            true
        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

    private fun createUpDrawable()  = with(DrawerArrowDrawable(toolbar.ctx)){
            progress = 1f
            this
        }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if( dy > 0) toolbar.slideExit() else toolbar.slideEnter()

            }
        })
    }

}