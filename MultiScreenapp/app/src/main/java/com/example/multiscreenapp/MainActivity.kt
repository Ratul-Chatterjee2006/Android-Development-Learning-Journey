package com.example.multiscreenapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.multiscreenapp.databinding.ActivityMainBinding
import android.content.Intent

class MainActivity : AppCompatActivity() {


    companion object{
        const val KEY="com.example.multiscreenapp.MainActivity.KEY"
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonorder.setOnClickListener {
            val ordersplaced = binding.eT1.text.toString() + " " +
                    binding.eT2.text.toString() + " " +
                    binding.eT3.text.toString() + " " +
                    binding.eT4.text.toString()
            val intent=Intent(this, OrderFood::class.java)
            intent.putExtra(KEY,ordersplaced)
            startActivity(intent)
        }
    }
}
