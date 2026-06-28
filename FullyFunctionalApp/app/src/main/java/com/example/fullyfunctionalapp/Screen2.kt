package com.example.fullyfunctionalapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen2)


        val appdev=findViewById<CardView>(R.id.appdev)
        val ml=findViewById<CardView>(R.id.ml)
        val ai=findViewById<CardView>(R.id.ai)
        val ios=findViewById<CardView>(R.id.iot)
        val blockchain=findViewById<CardView>(R.id.blockchain)
        val webdev=findViewById<CardView>(R.id.webdev)

         appdev.setOnClickListener {
             val intent=Intent(this,Screen3::class.java)
             intent.putExtra("TOPIC_NAME","Android App Development")
             intent.putExtra("TOOLS",arrayOf("XML","Kotlin","Java","Android Studio","Gradle"))
             intent.putExtra("URL",arrayOf("https://www.youtube.com/playlist?list=PLV8vIYTIdSnai886vBer6WgpqhQkPZrLB","https://www.youtube.com/playlist?list=PLRKyZvuMYSIMW3-rSOGCkPlO1z_IYJy3G"
             ,"https://www.youtube.com/watch?v=NNLoi8QqzaY","https://www.youtube.com/watch?v=InigFUSiPl8&list=PLu0W_9lII9aiL0kysYlfSOUgY5rNlOhUd","https://www.youtube.com/watch?v=nCcWxBNEe8c&list=PLiOIhBfKi8AI10jZWF50pyNsLXgAG-vwy"))
             intent.putExtra("DESCRIPTION","Build mobile apps for Android devices using Kotlin and Android SDK.")
             startActivity(intent)
         }

         ai.setOnClickListener {
             val intent=Intent(this,Screen3::class.java)
             intent.putExtra("TOPIC_NAME","Artificial Intelligence")
             intent.putExtra("TOOLS",arrayOf("Python","Jupyter","Numpy","Tensorflow","Keras"))
             intent.putExtra("URL",arrayOf("https://www.youtube.com/playlist?list=PLTV_nsuD2lf7JOwZdSWuup-YO0AUaDQti","https://www.youtube.com/playlist?list=PL8Oih_M59uNUddesejbfKiNll7n-NVd3g",
                 "https://www.youtube.com/watch?v=VXU4LSAQDSc","https://www.youtube.com/playlist?list=PLeo1K3hjS3uu7CxAacxVndI4bE_o3BDtO","https://www.youtube.com/playlist?list=PLjVLYmrlmjGdet9XI7qtPzgZQRmBI1GN3"))
             intent.putExtra("DESCRIPTION","Artificial Intelligence involves building smart machines capable of performing tasks that typically require human intelligence.")
             startActivity(intent)
         }

         ml.setOnClickListener {
             val intent=Intent(this,Screen3::class.java)
             intent.putExtra("TOPIC_NAME","Machine Learning")
             intent.putExtra("TOOLS",arrayOf("Python","Numpy & Pandas","Matplotlib","Scikit-Learn"))
             intent.putExtra("URL",arrayOf("https://www.youtube.com/playlist?list=PLTV_nsuD2lf7JOwZdSWuup-YO0AUaDQti","https://www.youtube.com/playlist?list=PL9n0l8rSshSnragNblKDBsT8Xu3otp3jA",
                 "https://www.youtube.com/playlist?list=PL9n0l8rSshSnragNblKDBsT8Xu3otp3jA","https://www.youtube.com/playlist?list=PLVHgQku8Z9348d6xguTn8zbcUYntz3dQG"))
             intent.putExtra("DESCRIPTION","Machine Learning is a subset of AI that enables systems to learn from data automatically.")
             startActivity(intent)
         }

          ios.setOnClickListener {
              val intent=Intent(this,Screen3::class.java)
              intent.putExtra("TOPIC_NAME","IOS App Development")
              intent.putExtra("TOOLS",arrayOf("Swift","Objective-C","Git","UIKit","SwiftUI"))
              intent.putExtra("URL",arrayOf("https://www.youtube.com/playlist?list=PLWZIhpNhtvfqBd00bF3ouroGHMPe-iroO","https://www.youtube.com/playlist?list=PLWZIhpNhtvfoNC3gEHCHA4rZCDwb8f8R9",
                  "https://www.youtube.com/watch?v=Ez8F0nW6S-w","https://www.youtube.com/playlist?list=PL0X6fGhFFNTfUIRSuiVFZmuMGeSUYkNzh","https://www.youtube.com/playlist?list=PL9TY7jc64Gd6_gFvPD_OswOHWigqAzNsY"))
              intent.putExtra("DESCRIPTION","Build apps for iPhone and iPad using Swift and Apple's development tools.")
              startActivity(intent)
          }

           webdev.setOnClickListener {
               val intent=Intent(this,Screen3::class.java)
               intent.putExtra("TOPIC_NAME","Web Development")
               intent.putExtra("TOOLS", arrayOf("HTML","CSS","Javascript","React","Node.js"))
               intent.putExtra("URL",arrayOf("https://www.youtube.com/playlist?list=PLwmDa-QvqlfgD_EU7KFRiB2YUn_wSnxW4","https://www.youtube.com/playlist?list=PLHquSSTADIulENvVw__aaVA_btldIn-zn",
                   "https://www.youtube.com/playlist?list=PLQEaRBV9gAFuf-27K64l7-hV7o0fr9zx7","https://www.youtube.com/playlist?list=PLQEaRBV9gAFvcKA4jL9BTLBfmBSGMWSOe","https://www.youtube.com/playlist?list=PL1BztTYDF-QPdTvgsjf8HOwO4ZVl_LhxS"))
               intent.putExtra("DESCRIPTION","Web development covers building websites and web applications for browsers.")
               startActivity(intent)
           }

           blockchain.setOnClickListener {
               val intent=Intent(this,Screen3::class.java)
               intent.putExtra("TOPIC_NAME","Block Chain")
               intent.putExtra("TOOLS", arrayOf("Solidity","Web3.js","Ganache","Truffle","MetaMask","Ethereum"))
               intent.putExtra("URL",arrayOf("https://www.youtube.com/playlist?list=PLR0uCBk15bq9a__TgfcZ7oA73MTEZ3NOK","https://www.youtube.com/watch?v=h5nGnO_E7Xo&list=PLgPmWS2dQHW8Ev0iC0zyBLikUSV-A22rC",
                   "https://www.youtube.com/watch?v=kkiaBPcnc6U&list=PLde8eDss7CuQLM46HkFKnTyTNoKccQanI","https://www.youtube.com/watch?v=kkiaBPcnc6U&list=PLde8eDss7CuQLM46HkFKnTyTNoKccQanI","https://www.youtube.com/watch?v=TNZngOM9jk4&list=PLXy-sJbO0dMTcg6rBjEH6EIU9-t7WpNea",
                   "https://www.youtube.com/playlist?list=PLgPmWS2dQHW9FmqNqug3M5ooNuRqP-alu"))
               intent.putExtra("DESCRIPTION","Blockchain is a decentralized ledger technology used in crypto and secure systems.")
               startActivity(intent)
           }

        val calling=findViewById<Button>(R.id.support)

        calling.setOnClickListener {
            val intent=Intent(Intent.ACTION_DIAL)
            intent.data=Uri.parse("tel:18001654")
            startActivity(intent)

        }
    }
}
