package com.example.listviewproject

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class Myadapter(val context: Activity, val arraylist: ArrayList<user>) :
    ArrayAdapter<user>(context, R.layout.eachrow, arraylist) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater= LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.eachrow,null)

        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.tvname)
        val msg = view.findViewById<TextView>(R.id.tvmessage)
        val lasttime = view.findViewById<TextView>(R.id.tvlasttime)

        name.text = arraylist[position].Name
        msg.text = arraylist[position].Lastmsg
        lasttime.text = arraylist[position].Time
        image.setImageResource(arraylist[position].imageid)

        return view
    }
}
