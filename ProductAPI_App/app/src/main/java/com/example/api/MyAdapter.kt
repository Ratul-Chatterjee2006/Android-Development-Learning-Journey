package com.example.api

import android.app.Activity
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity,val productlist: List<Product>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    class MyViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        lateinit var title: TextView
        lateinit var image: ShapeableImageView
        lateinit var ratingBar: RatingBar

        init {
            title=itemview.findViewById(R.id.producttitle)
            image=itemview.findViewById(R.id.productimage)
            ratingBar=itemview.findViewById(R.id.ratingBar)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val itemview= LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentitem=productlist[position]
        holder.title.text=currentitem.title
        holder.ratingBar.rating = currentitem.rating.toFloat()

        if (currentitem.rating <= 2.7) {
            holder.ratingBar.progressTintList = ColorStateList.valueOf(Color.RED)
        } else {
            holder.ratingBar.progressTintList = ColorStateList.valueOf("#FFD700".toColorInt())
        }

        // image view , how to show image in image view if the image is in form of url,
        // add the dependencies in gradle (implementation 'com.squareup.picasso:picasso:2.0.0')
        Picasso.get().load(currentitem.thumbnail).into(holder.image);
    }

    override fun getItemCount(): Int {
        return productlist.size
    }



}