package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var signInBtn : Button
    lateinit var signUpBtn : Button
    lateinit var username : EditText
    lateinit var password : EditText

    fun initComp(){
        signInBtn = findViewById(R.id.sign_in_btn)
        signUpBtn = findViewById(R.id.sign_up_btn)
        username = findViewById(R.id.et_username)
        password = findViewById(R.id.et_password)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initComp()

        val bundle = intent.extras
        val uName = bundle?.getString("username")
        val pass = bundle?.getString("password")

        if(bundle != null) username.setText(uName)


        signInBtn.setOnClickListener {
            if (username.text.toString()==uName && password.text.toString()==pass){
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("User", User(username.text.toString()))
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, R.string.toast_msg, Toast.LENGTH_LONG).show()
            }
        }
        signUpBtn.setOnClickListener {
            val intent = Intent(this@LoginActivity, Register::class.java)
            startActivity(intent)
        }


    }
}