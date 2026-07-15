package com.example.newsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.databinding.ActivityDetailviewBinding

class Detailview : AppCompatActivity() {

    private lateinit var binding: ActivityDetailviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val heading = intent.getStringExtra("Heading")
        val imageId = intent.getIntExtra("NewsImage", R.drawable.news1)
        val content = intent.getStringExtra("NewsContent")

        binding.NewsHeading.text = heading
        binding.NewsContent.text = content
        binding.imageView.setImageResource(imageId)
    }
}
