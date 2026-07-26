package com.example.api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        init {
            title=itemview.findViewById(R.id.producttitle)
            image=itemview.findViewById(R.id.productimage)
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
        // image view , how to show image in image view if the image is in form of url,
        // add the dependencies in gradle (implementation 'com.squareup.picasso:picasso:2.0.0')
        Picasso.get().load(currentitem.thumbnail).into(holder.image);
    }

    override fun getItemCount(): Int {
        return productlist.size
    }



}