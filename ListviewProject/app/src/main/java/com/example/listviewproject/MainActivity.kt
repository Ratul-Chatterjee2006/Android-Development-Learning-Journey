package com.example.listviewproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listviewproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var Userarraylist: ArrayList<user>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val name = arrayOf("Ratul", "Saumiya", "Aman", "Ananya", "Souhadra", "Priyanshu")

        val lastmsg = arrayOf(
            "I am built different",
            "Hey Everyone",
            "Python is fun",
            "I have exam at 10th july",
            "Mother will Scold me",
            "Cool"
        )

        val lastmsgtime =
            arrayOf("05:43 PM", "06:25 AM", "06:30 PM", "07:05 PM", "08:03 PM", "11:46 AM")

        val Phoneno = arrayOf(
            "7439057231",
            "786453739",
            "8547397805",
            "99151007864",
            "7003694754",
            "8910126049"
        )

        val imgid = intArrayOf(
            R.drawable.image_1,
            R.drawable.image_9,
            R.drawable.image_8,
            R.drawable.image_7,
            R.drawable.image_6,
            R.drawable.image_5
        )

        Userarraylist = ArrayList()

        for (eachindex in name.indices) {
            val user = user(
                name[eachindex],
                lastmsg[eachindex],
                lastmsgtime[eachindex],
                Phoneno[eachindex],
                imgid[eachindex]
            )
            Userarraylist.add(user)

        }

        binding.listing.isClickable = true
        binding.listing.adapter = Myadapter(this, Userarraylist)

        binding.listing.setOnItemClickListener { parent, view, position, id ->

        val username=name[position]
        val img=imgid[position]
        val lasttime=lastmsgtime[position]
        val phone=Phoneno[position]

        val i= Intent(this, Useractivity::class.java)
        i.putExtra("UserName",username)
        i.putExtra("UserImage",img)
        i.putExtra("UserLastTime",lasttime)
        i.putExtra("UserPhone",phone)
        startActivity(i)


        }
    }
}
