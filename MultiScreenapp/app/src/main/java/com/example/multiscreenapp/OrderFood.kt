package com.example.multiscreenapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.multiscreenapp.databinding.ActivityOrderFoodBinding

class OrderFood : AppCompatActivity() {
    private lateinit var binding: ActivityOrderFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOrderFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val orderofcustomer = intent.getStringExtra(MainActivity.KEY)
        binding.tvorder.text = "Order Placed: "+orderofcustomer.toString()
    }
}
