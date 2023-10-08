package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

lateinit var usernameInfo : TextView
lateinit var fragBtn : Button

    private fun initComponents(){
        usernameInfo = findViewById(R.id.usernameInfo)
        fragBtn = findViewById(R.id.fragBtn)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()

        val username_data = intent.getParcelableExtra<User>("User")?.username
        usernameInfo.text = "Nama Pengguna: $username_data"

        fragBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainFragment::class.java))
        }

    }
        fun keypadClose(view : View){
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
}