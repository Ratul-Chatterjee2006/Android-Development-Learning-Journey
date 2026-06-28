package com.example.fullyfunctionalapp

import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Handler().postDelayed(
            {
                val intent= Intent(this,Screen1::class.java)
                startActivity(intent)
                finish()
            },3000
        )
        }
    }
