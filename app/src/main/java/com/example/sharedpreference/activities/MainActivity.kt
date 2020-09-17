package com.example.sharedpreference.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.R
import com.example.sharedpreference.helpers.SessionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionManager = SessionManager(this)

        init()
    }

    private fun init() {
        if (sessionManager.isLoggedIn())
            startActivity(Intent(this, ActivityHome::class.java))

        button_login.setOnClickListener {
            startActivity(Intent(this, ActivityLogin::class.java))
        }

        button_register.setOnClickListener {
            startActivity(Intent(this, ActivityRegister::class.java))
        }
    }
}