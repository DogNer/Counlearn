package com.example.counlearn.FirstScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.counlearn.MainActivity
import com.example.counlearn.R
import com.firebase.ui.auth.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Register_activity : AppCompatActivity() {
    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var name : EditText

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        val btnback = findViewById<ImageButton>(R.id.btn_back)
        btnback.setOnClickListener {
            val intent = Intent(this, FirstScreen::class.java)
            startActivity(intent)
            finish()
        }

        email = findViewById(R.id.textEmail)
        password = findViewById(R.id.textPassword)
        name = findViewById(R.id.textName)

        val btnRegister = findViewById<AppCompatButton>(R.id.btn_register)

        btnRegister.setOnClickListener {
            val emailText = email.text.toString()
            val passwordText = password.text.toString()
            val nameText = name.text.toString()
            
            if(emailText.isEmpty()) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            }
            else if (passwordText.isEmpty()){
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            }
            else if (nameText.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else {
                singup(nameText, emailText, passwordText)
            }
        }
    }

    private fun singup(name: String, emailText: String, passwordText: String) {
        mAuth.createUserWithEmailAndPassword(emailText, passwordText)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    addUserToDatabase(name, emailText, passwordText, mAuth.currentUser?.uid)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Some error occurred", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addUserToDatabase(name: String, emailText: String, passwordText: String, uid: String?) {
        mDbRef = FirebaseDatabase.getInstance().getReference()

        if (uid != null) {
            mDbRef.child("Users").child(uid).setValue(com.example.counlearn.Modals.User(name, emailText, passwordText, uid, "nothing"))
        }
    }


}