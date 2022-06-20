package com.example.counlearn.FirstScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.counlearn.MainActivity
import com.example.counlearn.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirstScreen : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;
    private lateinit var firebaseUser: FirebaseUser


    override fun onStart() {
        super.onStart()
        val user = Firebase.auth.currentUser
        if (user != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

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