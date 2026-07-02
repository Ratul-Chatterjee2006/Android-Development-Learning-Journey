package com.example.customisedalertbox

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.customisedalertbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialog= Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        val buttongood=dialog.findViewById<Button>(R.id.btngood)
        val buttonfeedback=dialog.findViewById<Button>(R.id.btnfeedback)

        buttongood.setOnClickListener {
            Toast.makeText(applicationContext,"Congratulation for showing up today.", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        buttonfeedback.setOnClickListener {
            //intents or toast
        }

        binding.btnclick.setOnClickListener{
        dialog.show()
        }

        }
    }
