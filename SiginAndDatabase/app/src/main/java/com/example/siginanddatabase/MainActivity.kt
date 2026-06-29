package com.example.siginanddatabase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val signupbutton = findViewById<Button>(R.id.btnsignup)
        val emailaddress=findViewById<EditText>(R.id.etMail)
        val password=findViewById<EditText>(R.id.etpass)
        val etname=findViewById<EditText>(R.id.etName)
        val phoneno=findViewById<EditText>(R.id.etphone)
        val uniqueid=findViewById<EditText>(R.id.uniqueId)

        signupbutton.setOnClickListener {

            val name = etname.text.toString()
            val email = emailaddress.text.toString()
            val pass = password.text.toString()
            val phone = phoneno.text.toString()
            val id = uniqueid.text.toString()

            val user= User(name,email,pass,phone,id)

            database= FirebaseDatabase.getInstance().getReference("Users")
            database.child(id).setValue(user).addOnSuccessListener {
                etname.text?.clear()
                emailaddress.text?.clear()
                password.text?.clear()
                phoneno.text?.clear()
                uniqueid.text?.clear()
                Toast.makeText(this,"User Registered!", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed!", Toast.LENGTH_SHORT).show()
            }
        }


        }
    }
