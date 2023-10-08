package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Register : AppCompatActivity() {
    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var submitBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        username = findViewById(R.id.et_username)
        password = findViewById(R.id.et_password)
        submitBtn = findViewById(R.id.submitBtn)


        submitBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("username", username.text.toString())
            bundle.putString("password", password.text.toString())

            val intent = Intent(this@Register, LoginActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}