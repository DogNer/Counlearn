package com.example.counlearn.FirstScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.counlearn.MainActivity
import com.example.counlearn.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class LoginActivity : AppCompatActivity() {
    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var btnLogin: AppCompatButton

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        val btnback = findViewById<ImageButton>(R.id.btn_back)
        btnback.setOnClickListener {
            val intent = Intent(this, FirstScreen::class.java)
            startActivity(intent)
            finish()
        }

        email = findViewById(R.id.textEmail)
        password = findViewById(R.id.textPassword)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            if(emailText.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            }
            else if (passwordText.toString().isEmpty()){
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            }
            else {
                login(emailText, passwordText)
            }
        }
    }

    private fun login(emailText: String, passwordText: String) {
        mAuth.signInWithEmailAndPassword(emailText, passwordText)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Some error occurred", Toast.LENGTH_SHORT).show()
                }
            }
    }
}