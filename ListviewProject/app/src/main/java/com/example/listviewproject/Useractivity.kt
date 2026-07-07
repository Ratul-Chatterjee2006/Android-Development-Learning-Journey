package com.example.listviewproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listviewproject.databinding.ActivityUseractivityBinding

class Useractivity : AppCompatActivity() {

    lateinit var binding: ActivityUseractivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUseractivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name=intent.getStringExtra("UserName")
        val phonenumber=intent.getStringExtra("UserPhone")
        val image=intent.getIntExtra("UserImage",R.drawable.image_1)
        val time=intent.getStringExtra("UserLastTime")

        binding.tvname.text = name
        binding.tvph.text = phonenumber
        binding.tvtime.text = time
        binding.profileImage.setImageResource(image)

    }
}
