package com.example.api

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    lateinit var myadapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView=binding.recyclerview
        val retrofitbuilder= Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API_interface::class.java)

        val retrofitdata=retrofitbuilder.getProductdata()

        retrofitdata.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
            // if api call is success then use the data of API and show in your app
            var responseBody=response.body()
            val productlist=responseBody?.products!!

            myadapter= MyAdapter(this@MainActivity,productlist)
            recyclerView.adapter=myadapter
            recyclerView.layoutManager= LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
            // if api call fails then create a fail screen or show error message
                Log.d("MainActivity","OnFailure"+t.message)
            }
        })






        }
    }
