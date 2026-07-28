package com.example.notificationoverview

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notificationoverview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "ChannelId"
    val CHANNEL_NAME = "ChannelName"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CreateNotificationChannel()

        //pending content

        val intent= Intent(this, MainActivity::class.java)
        val pendingIntent= PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_MUTABLE)


        val largeIcon = BitmapFactory.decodeResource(resources, R.drawable.img)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Someone Send you a friend request")
            .setContentText("Click to accept or decline")
            .setSmallIcon(R.drawable.round_call_to_action_24)
            .setLargeIcon(largeIcon)
            .setColor(Color.GREEN)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) // Set to Default priority
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

        binding.button.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                        101
                    )
                    return@setOnClickListener
                }
            }
            notificationManager.notify(1, notification)
        }


    }


    fun CreateNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "This is my Notification Channel"
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}
