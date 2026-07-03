package com.example.demoexam

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        
        val resultScore = intent.getIntExtra("Answers", 0)
        val quizData = intent.getSerializableExtra("QuizData") as? Array<Question>
        
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        scoreTextView.text = "Score: $resultScore / 8"
        
        if (quizData != null) {
            val recyclerView = findViewById<RecyclerView>(R.id.resultRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ResultAdapter(quizData)
        }
    }
}

