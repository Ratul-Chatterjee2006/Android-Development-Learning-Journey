package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // by default home fragment should be selected

        ReplaceWithFragment(Home())
        binding.bottomlayout.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> ReplaceWithFragment(Home())
                R.id.search -> ReplaceWithFragment(Search())
                R.id.notify -> ReplaceWithFragment(Notification())
                R.id.profile -> ReplaceWithFragment(Profile())
                else -> {

                }
            }
            true

        }
        }

    private fun ReplaceWithFragment(fragment : Fragment) {

        val fragmentmanager=supportFragmentManager
        val fragmenttranaction=fragmentmanager.beginTransaction()
        fragmenttranaction.replace(R.id.frameLayout,fragment)
        fragmenttranaction.commit()

    }
}
