package com.example.motivationapp

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences (context: Context) { //Receber o contexto por parâmetro via construtor

    private val security: SharedPreferences =
        context.getSharedPreferences("MotivationApp", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        security.edit().putString(key, str).apply() //Salvando valor dentro do shared preferences
    }

    fun getString(key: String) : String {
        return security.getString(key, "") ?: "" //Elvis operator, caso a string seja nula, retorna vazio
    }
}