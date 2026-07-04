package com.example.photoframeapp

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photoframeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var image: ImageView

    val names=arrayOf("Lord Vishnu","Netaji Subhash Chandra Bose","Ratul Chatterjee","Mahendra Singh Dhoni","Sunil Chetri","Lionel Messi","John Cena","Virat Kholi","Ironman","Spiderman")
    var index=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.imgprev.setOnClickListener{

            val idcurrentimagestring="image_$index"
            //convert string id into integer associated with it
            val idcurrentimageint=this.resources.getIdentifier(idcurrentimagestring,"id",packageName)
            image=findViewById(idcurrentimageint)
            image.alpha=0f

            index=(10+index-1)%10

            val idimagetoshowstring="image_$index"
            //convert string id into integer associated with it
            val idimagetoshowint=this.resources.getIdentifier(idimagetoshowstring,"id",packageName)
            image=findViewById(idimagetoshowint)
            image.alpha=1f

            binding.textView.text=names[index]
        }

        binding.imgnext.setOnClickListener {

            val idcurrentimagestring="image_$index"
            //convert string id into integer associated with it
            val idcurrentimageint=this.resources.getIdentifier(idcurrentimagestring,"id",packageName)
            image=findViewById(idcurrentimageint)
            image.alpha=0f

            index=(10+index+1)%10

            val idimagetoshowstring="image_$index"
            //convert string id into integer associated with it
            val idimagetoshowint=this.resources.getIdentifier(idimagetoshowstring,"id",packageName)
            image=findViewById(idimagetoshowint)
            image.alpha=1f

            binding.textView.text=names[index]
        }

        }
    }
