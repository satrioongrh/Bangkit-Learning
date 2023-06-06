package com.example.mystoryapp1.helper

import android.content.Context
import android.content.SharedPreferences

class PrefDataUser(context: Context) {

    private var SHARED_PREF = "DATA_USER"
    private var sharedPref: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun putDataUser(key: String, value: String){
        editor.putString(key, value)
        editor.apply()
    }

    fun getDataUser(key: String): String? {
        return sharedPref.getString(key, null)
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun isLogin(key: String) : Boolean {
        return sharedPref.getBoolean(key, false)
    }



}