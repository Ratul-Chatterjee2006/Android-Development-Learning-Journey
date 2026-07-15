package com.example.newsapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Myadapter(var context: Activity, var newsarrayList: ArrayList<News>) :
    RecyclerView.Adapter<Myadapter.MyViewHolder>() {

    private var myListner: OnItemClickListner? = null

    interface OnItemClickListner {
        fun onItemClick(position: Int)
    }

    fun SetonItemClickListner(Listner: OnItemClickListner) {
        myListner = Listner
    }
    // To create new view instance
// when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Myadapter.MyViewHolder {

        val itemView= LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView,myListner)
    }


    // Populate items with data
        override fun onBindViewHolder(holder: Myadapter.MyViewHolder, position: Int) {

            val currentitem=newsarrayList[position]
            holder.tvheadingtitle.text=currentitem.NewsHeading
            holder.tvimage.setImageResource(currentitem.Newsimg)

        }

        // return how many list items are present in your array
        override fun getItemCount(): Int {
        return newsarrayList.size
        }

    // it holds view so that view is not created everytime, so memory can be saved
        class MyViewHolder(itemView: View, listner: OnItemClickListner?) : RecyclerView.ViewHolder(itemView) {
        val tvheadingtitle: TextView = itemView.findViewById(R.id.tvheadingtitle)
        val tvimage: ShapeableImageView = itemView.findViewById(R.id.tvimage)

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listner?.onItemClick(position)
                }
            }
        }
    }}


    
