package com.example.viewbinding

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.checkBox.isChecked) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
            } else {
                binding.checkBox.buttonTintList = ColorStateList.valueOf(Color.RED)
                Toast.makeText(this, "Please Agree to all T&C", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }
