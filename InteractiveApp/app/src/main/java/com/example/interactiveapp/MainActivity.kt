package com.example.interactiveapp

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val ButtonDark=findViewById<Button>(R.id.btnDark)
        val ButtonRead=findViewById<Button>(R.id.btnRead)
        val layout=findViewById<LinearLayout>(R.id.linearlayout)

        ButtonDark.setOnClickListener {
        layout.setBackgroundResource(R.color.Black)
        }

        ButtonRead.setOnClickListener {

        layout.setBackgroundResource(R.color.Banana)

        }


        }
    }
