package com.example.webview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)



        val webViewvariable = findViewById<WebView>(R.id.Webview)
        webviewsetup(webViewvariable)
        }

    private fun webviewsetup(a: WebView)
    {
        a.webViewClient = WebViewClient()

        a.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
            loadUrl("https://www.isro.gov.in/")

        }
    }
    }
