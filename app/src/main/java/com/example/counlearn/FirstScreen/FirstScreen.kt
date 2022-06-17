package com.example.counlearn.FirstScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.counlearn.R

class FirstScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        val btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            //finish()
        }

        val btn_register = findViewById<Button>(R.id.btn_register)
        btn_register.setOnClickListener{
            val intent = Intent(this, Register_activity::class.java)
            startActivity(intent)
            //finish()
        }
    }
}