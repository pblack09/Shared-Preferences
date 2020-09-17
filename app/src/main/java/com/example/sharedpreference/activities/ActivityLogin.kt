package com.example.sharedpreference.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import com.example.sharedpreference.R
import com.example.sharedpreference.helpers.SessionManager
import kotlinx.android.synthetic.main.activity_login.*

class ActivityLogin : AppCompatActivity(), View.OnClickListener {

    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionManager = SessionManager(this)

        init()
    }

    private fun init() {
        check_box_login.setOnClickListener {
            login_password.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        }

        go_to_register.setOnClickListener(this)
        button_login.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view) {

            go_to_register -> {
                startActivity(Intent(this, ActivityRegister::class.java))
            }

            button_login -> {
                var email = login_email.text.toString()
                var password = login_password.text.toString()
                if (sessionManager.login(email, password))
                    startActivity(Intent(this, ActivityHome::class.java))
                else {
                    login_password.text.clear()
                    Toast.makeText(
                        applicationContext,
                        "Incorrect Login Credentials. Please try again.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }
}