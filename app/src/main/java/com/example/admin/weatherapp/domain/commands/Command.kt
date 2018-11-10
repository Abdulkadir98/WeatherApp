package com.example.admin.weatherapp.domain.commands

/**
 * Created by admin on 11/2/2018.
 */
public interface Command<out T> {
    fun execute() : T
}