package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myrecyclerview: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myrecyclerview = binding.recyclerview
        myrecyclerview.layoutManager = LinearLayoutManager(this)

        val imagearray=arrayOf(
            R.drawable.news1,
            R.drawable.news2,
            R.drawable.news3,
            R.drawable.news4,
            R.drawable.news5,
            R.drawable.news6,
            R.drawable.news7,
            R.drawable.news8,
            R.drawable.news9,
            R.drawable.news10
        )

        val newsHeadingarray = arrayOf(
            "Microsoft To Lay Off 4,800 Workers In Latest Wave Of AI-Led Job Cuts",
            "Crucial Ram temple trust meeting on July 6; treasurer distances himself from donation row",
            "Heavy rain to continue till July 8: Maharashtra on high alert, says CM Fadnavis | Monsoon LIVE updates",
            "Mumbai rains | Pune–Mumbai Expressway, old Mumbai–Pune Highway shut due do to landslip, heavy rainfall",
            "Europe's heatwave lifts demand for China's portable air conditioners",
            "Global push for AI governance amid warnings of ‘catastrophic harm’",
            "From AI to ‘killer robots’: UN chief issues urgent governance call",
            "Students take out foot-march to protest against NEET paper leaks:Pay tribute to deceased students, raise slogans during rally",
            "Prabhsimran credits Yuvi, Ricky for India call-up",
            "FIFA World Cup: Refereeing chief denies bias claims in Argentina-Egypt game"
        )

        val newsDetail = arrayOf(
            getString(R.string.news_content1),
            getString(R.string.news_content2),
            getString(R.string.news_content3),
            getString(R.string.news_content4),
            getString(R.string.news_content5),
            getString(R.string.news_content6),
            getString(R.string.news_content7),
            getString(R.string.news_content8),
            getString(R.string.news_content9),
            getString(R.string.news_content10)
        )

        newsArrayList = arrayListOf<News>()

        for (eachindex in imagearray.indices) {
            val news = News(newsHeadingarray[eachindex], imagearray[eachindex], newsDetail[eachindex])
            newsArrayList.add(news)
        }

        var myadapter=Myadapter(this,newsArrayList)
        myrecyclerview.adapter=myadapter

        myadapter.SetonItemClickListner(object: Myadapter.OnItemClickListner{
            override fun onItemClick(position: Int) {
                val intent=Intent(this@MainActivity,Detailview::class.java)
                intent.putExtra("Heading",newsArrayList[position].NewsHeading)
                intent.putExtra("NewsImage",newsArrayList[position].Newsimg)
                intent.putExtra("NewsContent",newsArrayList[position].NewsContent)
                startActivity(intent)
            }
        })
    }
}
