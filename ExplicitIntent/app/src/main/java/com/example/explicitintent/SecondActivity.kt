package com.example.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val butn=findViewById<Button>(R.id.button2)

        butn.setOnClickListener {

            intent= Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }

    }
    }
