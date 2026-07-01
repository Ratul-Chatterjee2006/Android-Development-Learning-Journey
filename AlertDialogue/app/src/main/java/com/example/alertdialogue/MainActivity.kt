package com.example.alertdialogue

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alertdialogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder1= AlertDialog.Builder(this)
            builder1.setTitle("Are You Sure?")
            builder1.setMessage("Do You Want to Close the App?")
            builder1.setIcon(R.drawable.ic_exit)
            builder1.setPositiveButton("Yes", { dialogInterface, i ->
                //What action should be performed if Yes is clicked
                finish()
            })
            builder1.setNegativeButton("No",{ dialogInterface,i->
                // What action should be performed if no is clicked

            })
            builder1.show()
        }


        binding.button2.setOnClickListener {
            val options=arrayOf("Avengers","Avenger's Age of Ultron","Avenger's Infnity War","Avenger's Endgame","Avenger's Doomsday")
            val builder2= AlertDialog.Builder(this)
            builder2.setTitle("Which is Your Favorite MCU Avenger's Movie?")
            builder2.setSingleChoiceItems ( options, 0, { dialog, which ->
                // What happens when user selects an option
                Toast.makeText(this,"You Clicked On ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", { dialogInterface, i ->
                //What action should be performed if submit is clicked

            })
            builder2.setNegativeButton("Decline",{ dialogInterface,i->
                // What action should be performed if decline is clicked

            })
            builder2.show()
        }


        binding.button3.setOnClickListener {

            val options=arrayOf("Avengers","Avenger's Age of Ultron","Avenger's Infnity War","Avenger's Endgame","Avenger's Doomsday")
            val builder3= AlertDialog.Builder(this)
            builder3.setTitle("Which is Your Favorite MCU Avenger's Movie?")
            builder3.setMultiChoiceItems ( options, null, { dialog, which,ischecked ->
                // What happens when user selects an option
                Toast.makeText(this,"You Clicked On ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit", { dialogInterface, i ->
                //What action should be performed if submit is clicked

            })
            builder3.setNegativeButton("Decline",{ dialogInterface,i->
                // What action should be performed if decline is clicked

            })
            builder3.show()
        }




        }


    }
