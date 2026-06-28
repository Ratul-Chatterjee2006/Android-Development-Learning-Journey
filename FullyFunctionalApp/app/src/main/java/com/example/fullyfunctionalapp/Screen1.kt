package com.example.fullyfunctionalapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent


class Screen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_scrren1)

        val screen2=findViewById<Button>(R.id.letgo)

        screen2.setOnClickListener {
            intent=Intent(applicationContext,Screen2::class.java)
            startActivity(intent)
        }
        }
    }