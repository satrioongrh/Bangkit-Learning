package com.example.mystoryapp1.utils

import android.content.Context

class SessionManager (context: Context) {
    private val pref = context.getSharedPreferences("Session", Context.MODE_PRIVATE)
    private val editor = pref.edit()

    companion object {
        private const val KEY_TOKEN = "token"
        private const val KEY_IS_LOGGED_IN = "isLoggedIn"
    }

    fun saveAuthToken(token: String) {
        editor.putString(KEY_TOKEN, token)
        editor.putBoolean(KEY_IS_LOGGED_IN, true)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun getToken(): String? {
        return pref.getString(KEY_TOKEN, null)
    }

    fun clearSession() {
        editor.clear()
        editor.apply()
    }
}