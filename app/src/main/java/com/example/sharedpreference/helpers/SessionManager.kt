package com.example.sharedpreference.helpers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.core.content.ContextCompat.startActivity
import com.example.sharedpreference.activities.ActivityHome
import com.example.sharedpreference.models.User

class SessionManager(mContext: Context) {

    private val FILE_NAME = "default"
    private val KEY_NAME = "name"
    private val KEY_EMAIL = "email"
    private val KEY_PASSWORD = "password"
    private val KEY_IS_LOGGED_IN = "isLoggedIn"

    var sharedPreferences = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    var editor = sharedPreferences.edit()


    fun register(user: User){
        editor.putString(KEY_NAME, user.name)
        editor.putString(KEY_EMAIL, user.email)
        editor.putString(KEY_PASSWORD, user.password)
        editor.putBoolean(KEY_IS_LOGGED_IN, true)
        editor.commit()
    }

    fun login(email: String, password: String): Boolean {
        var userEmail = sharedPreferences.getString(KEY_EMAIL, null)
        var userPassword = sharedPreferences.getString(KEY_PASSWORD, null)
        if(userEmail.equals(email) && userPassword.equals(password)){
            editor.putBoolean(KEY_IS_LOGGED_IN, true)
            return true
        } else
            return false
    }

    fun getUserName(): String? {
        return sharedPreferences.getString(KEY_NAME, null)
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun logout(){
        editor.clear()
        editor.commit()
    }
}