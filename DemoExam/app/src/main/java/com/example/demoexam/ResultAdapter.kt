package com.example.demoexam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter(private val quiz: Array<Question>) :
    RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val questionText: TextView = view.findViewById(R.id.resultQuestionText)
        val correctAnswer: TextView = view.findViewById(R.id.resultCorrectAnswer)
        val explanation: TextView = view.findViewById(R.id.resultExplanation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val q = quiz[position]
        holder.questionText.text = q.text
        
        val correctOptions = q.correctAnswers.map { q.options[it] }.joinToString(", ")
        holder.correctAnswer.text = "Correct Answer(s): $correctOptions"
        holder.explanation.text = "Explanation: ${q.explanation}"
    }

    override fun getItemCount() = quiz.size
}
