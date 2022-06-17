package com.example.counlearn.FirstScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.counlearn.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnback = findViewById<ImageButton>(R.id.btn_back)
        btnback.setOnClickListener {
            val intent = Intent(this, FirstScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}