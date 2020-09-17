package com.example.sharedpreference.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.R
import com.example.sharedpreference.helpers.SessionManager
import kotlinx.android.synthetic.main.activity_home.*

class ActivityHome : AppCompatActivity() {

    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sessionManager = SessionManager(this)

        init()
    }

    private fun init() {
        var name = sessionManager.getUserName()
        text_name.text = name

        button_logout.setOnClickListener {
            sessionManager.logout()
            startActivity(Intent(this, ActivityLogin::class.java))
        }

    }
}