package com.example.testtask

import android.content.Context

//Сохраняем настройки приложения
class Settings(context: Context) {
    private val settings= context.getSharedPreferences("", Context.MODE_PRIVATE)

    var login: String
        get() = settings.getString("Login", "") ?: ""
        set(value) = settings.edit().putString("Login", value).apply()

    var password: String
        get() = settings.getString("Password", "") ?: ""
        set(value) = settings.edit().putString("Password", value).apply()

    var isCheckRemember: Boolean
        get() = settings.getBoolean("CheckRemember", false)
        set(value) = settings.edit().putBoolean("CheckRemember", value).apply()
}