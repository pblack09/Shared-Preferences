package com.example.sharedpreference.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import com.example.sharedpreference.R
import com.example.sharedpreference.helpers.SessionManager
import com.example.sharedpreference.models.User
import kotlinx.android.synthetic.main.activity_register.*

class ActivityRegister : AppCompatActivity(), View.OnClickListener {

    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sessionManager = SessionManager(this)

        init()
    }

    private fun init() {
        check_box_register.setOnClickListener {
            register_password.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        }

        button_register.setOnClickListener(this)
        go_to_login.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {

            button_register -> {
                var name = register_name.text.toString()
                var email = register_email.text.toString()
                var password = register_password.text.toString()
                var user = User(name, email, password)
                sessionManager.register(user)
                Toast.makeText(applicationContext, "Registration Successful", Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(this, ActivityLogin::class.java))
            }

            go_to_login -> {
                startActivity(Intent(this, ActivityLogin::class.java))
            }

        }
    }
}