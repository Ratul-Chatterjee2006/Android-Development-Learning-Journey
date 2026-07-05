package com.example.listviewadapters

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listviewadapters.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tasklist=arrayListOf<String>()
        tasklist.add("Attend Exam")
        tasklist.add("Complete the App Dev Project")
        tasklist.add("Work on Resume")
        tasklist.add("Improve internet presense")
        tasklist.add("Prepare for GATE Exam")
        tasklist.add("Push Projects on Github")
        tasklist.add("Teach the students")

        val adapterformylistview = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasklist)
        binding.listview.adapter=adapterformylistview

        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val text = "Clicked on Item: " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

        }


        }
    }
