package com.example.demoexam

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.demoexam.databinding.ActivityMainBinding
import android.content.Intent
import java.io.Serializable

// 1. Define types: MSQ (Checkboxes) vs MCQ (Radio Buttons)
enum class QuestionType {
    MSQ, MCQ
}

// 2. Data class to hold everything about a question
data class Question(
    val text: String,
    val options: Array<String>,
    val type: QuestionType,
    val correctAnswers: List<Int>, // Indices of correct answers
    val explanation: String
) : Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    
    // 3. Centralized Quiz Data
    private val quiz = arrayOf(
        Question(
            "Q1. Which one or more of the following need to saved on a context switch from T1 to T2? (MSQ)",
            arrayOf("Page table base register", "Stack Pointer", "Program Counter", "General Purpose Register"),
            QuestionType.MSQ,
            listOf(1, 2, 3),
            "Threads share the same address space, so the Page Table Base Register remains the same. However, each thread has its own stack and registers (PC, SP, GPRs)."
        ),
        Question(
            "Q2. The following postfix expression with single digit operands is evaluated using a stack  823^/23*+51*-  " +
                    "The top two elements of the stack after the first * is evaluated are:(MCQ)",
            arrayOf("6,1", "5,7", "3,2", "1,5"),
            QuestionType.MCQ,
            listOf(0),
            "After evaluating '8 2 3 ^ /', the stack contains [1]. Then '2 3 *' pushes 2 and 3, then multiplies them to get 6. The stack now has [1, 6]. The top two are 6 and 1."
        ),
        Question(
            "Q3. What is the time complexity of Bellman-Ford single-source shortest path algorithm on a complete graph of n vertices?(MCQ)",
            arrayOf("theta(n^2)", "theta(n^2logn)", "theta(n^3)", "theta(n^3logn)"),
            QuestionType.MCQ,
            listOf(2),
            "Bellman-Ford complexity is O(V*E). In a complete graph, E = V(V-1)/2, which is O(V^2). Thus, the total complexity is O(V * V^2) = O(V^3)."
        ),
        Question(
            "Q4. Let R=(A,B,C,D,E,F) be a relation scheme with the following dependencies C->F,E->A,EC->D,A->B. Which of the following is a key for R?(MCQ)",
            arrayOf("CD", "EC", "AE", "AC"),
            QuestionType.MCQ,
            listOf(1),
            "The closure of EC (EC+) includes E, C, A (from E->A), F (from C->F), D (from EC->D), and B (from A->B). Since EC+ contains all attributes, EC is a key."
        ),
        Question(
            "Q5. If P=3, R=27, T=243, then Q+S= ________ (MCQ)",
            arrayOf("110","80","90","40"),
            QuestionType.MCQ,
            listOf(2),
            "The sequence follows powers of 3: P=3^1, Q=3^2=9, R=3^3=27, S=3^4=81, T=3^5=243. Q+S = 9+81 = 90."
        ),
        Question(
            "Q6. Consider the three commands: PROMPT,HEAD and RCPT. Which of the following options indicates the order of execution of these commands?(MCQ)",
            arrayOf("HTTP,SMTP,FTP","FTP,HTTP,SMTP","SMTP,HTTP,FTP","HTTP,FTP,SMTP"),
            QuestionType.MCQ,
            listOf(1),
            "PROMPT is an FTP command, HEAD is an HTTP method, and RCPT is an SMTP command. The order is FTP, HTTP, SMTP."
        ),
        Question(
            "Q7. If a class B network on the Internet has a subnet mask of 255.255.248.0, What is the maximum number of host per subnet?(MCQ)",
            arrayOf("1022","1023","2046","2047"),
            QuestionType.MCQ,
            listOf(2),
            "The mask 255.255.248.0 has 11 bits for the host (3 from the third octet and 8 from the fourth). 2^11 - 2 = 2048 - 2 = 2046 hosts."
        ),
        Question(
            "Q8. Heap allocation is required for languages- (MCQ)",
            arrayOf("that support recursion","that use dynamic scope rules","that support dynamic data structures","None of the above"),
            QuestionType.MCQ,
            listOf(2),
            "Dynamic data structures whose size or lifetime is not known at compile time require heap allocation for flexible memory management."
        )
    )

    // Storage to "remember" choices when moving Previous/Next
    private val savedMcqAnswers = IntArray(quiz.size) { -1 }
    private val savedMsqAnswers = Array(quiz.size) { i -> BooleanArray(quiz[i].options.size) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exitbtn.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Do You Want to Close the App?")
                .setMessage("All Selected options will be deleted")
                .setIcon(R.drawable.ic_exit)
                .setPositiveButton("Yes") { _, _ -> finish() }
                .setNegativeButton("No", null)
                .show()
        }

        binding.answer.setOnClickListener {
            // Reset selections when starting new quiz
            savedMcqAnswers.fill(-1)
            for (arr in savedMsqAnswers) arr.fill(false)
            showQuestion(0)
        }
    }

    private fun showQuestion(index: Int) {
        if (index >= quiz.size) {
            calculateAndSubmit()
            return
        }

        val q = quiz[index]
        val builder = AlertDialog.Builder(this)
        
        val titleView = TextView(this)
        titleView.text = q.text
        titleView.textSize = 18f
        titleView.setTypeface(null, Typeface.BOLD)
        titleView.setPadding(48, 48, 48, 24)
        titleView.setTextColor(Color.BLACK)
        builder.setCustomTitle(titleView)

        // Use the saved arrays so choices aren't lost when moving between questions
        if (q.type == QuestionType.MSQ) {
            builder.setMultiChoiceItems(q.options, savedMsqAnswers[index]) { _, which, isChecked ->
                savedMsqAnswers[index][which] = isChecked
            }
        } else {
            builder.setSingleChoiceItems(q.options, savedMcqAnswers[index]) { _, which ->
                savedMcqAnswers[index] = which
            }
        }

        val buttonText = if (index == quiz.size - 1) "Submit" else "Next"
        builder.setPositiveButton(buttonText) { _, _ ->
            showQuestion(index + 1)
        }

        builder.setNeutralButton("Previous") { _, _ ->
            if (index > 0) showQuestion(index - 1)
        }

        builder.setNegativeButton("Clear", null)
        
        val dialog = builder.create()
        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener {
            val listView = dialog.listView
            if (q.type == QuestionType.MSQ) {
                savedMsqAnswers[index].fill(false)
                for (i in q.options.indices) listView.setItemChecked(i, false)
            } else {
                savedMcqAnswers[index] = -1
                listView.clearChoices()
                listView.requestLayout()
            }
        }
    }

    private fun calculateAndSubmit() {
        var finalScore = 0
        quiz.forEachIndexed { i, q ->
            if (q.type == QuestionType.MCQ) {
                if (q.correctAnswers.contains(savedMcqAnswers[i])) {
                    finalScore++
                }
            } else {
                val selectedIndices = savedMsqAnswers[i].indices.filter { savedMsqAnswers[i][it] }
                if (selectedIndices.sorted() == q.correctAnswers.sorted()) {
                    finalScore++
                }
            }
        }
        val intent = Intent(this, Result::class.java)
        intent.putExtra("Answers", finalScore)
        intent.putExtra("QuizData", quiz)
        startActivity(intent)
    }
}
