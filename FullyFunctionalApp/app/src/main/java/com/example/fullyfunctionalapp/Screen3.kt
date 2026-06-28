package com.example.fullyfunctionalapp

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.flexbox.FlexboxLayout
import android.content.Intent
import android.net.Uri

class Screen3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen3)

        val topicname=intent.getStringExtra("TOPIC_NAME")
        val tools=intent.getStringArrayExtra("TOOLS")
        val description=intent.getStringExtra("DESCRIPTION")
        val urls=intent.getStringArrayExtra("URL")

        findViewById<TextView>(R.id.tvtopic).text=topicname
        findViewById<TextView>(R.id.tvDescription).text=description


        val container=findViewById<FlexboxLayout>(R.id.circlesContainer)

        tools?.forEachIndexed { index,tool ->
            val url=urls?.get(index)?:" "
            val circle = createCircleView(tool,url)
            container.addView(circle)
        }
        }

    private fun createCircleView(label: String, Url: String): TextView {
        val sizePx = (120 * resources.displayMetrics.density).toInt()

        val params = LinearLayout.LayoutParams(sizePx, sizePx).apply {
            setMargins(16, 16, 16, 16)

        }

        val circle = GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setStroke(6, Color.BLACK)
            setColor(Color.parseColor("#880E4F"))
        }

        return TextView(this).apply {
            setOnClickListener {
                val intent=Intent(Intent.ACTION_VIEW)
                intent.data=Uri.parse(Url)
                startActivity(intent)
            }
            layoutParams = params
            text = label
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
            textSize = 14f
            setTypeface(null, Typeface.BOLD)
            background = circle
        }
    }
    }
