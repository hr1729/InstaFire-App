package com.example.instafire.model

import android.content.Context
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instafire.R
import kotlinx.android.synthetic.main.item_posts.view.*

class Postadapter(val context: Context,val db:MutableList<Posts>):RecyclerView.Adapter<Postadapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name=view.txtname
        val crt=view.crt_time
        val img=view.imageView
        val des=view.about

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_posts, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ist=db[position]
        holder.des.text=ist.description
        holder.crt.text=DateUtils.getRelativeTimeSpanString(ist.crt)
        holder.name.text=ist.users?.name
        Glide.with(context).load(ist.image).into(holder.img)

    }

    override fun getItemCount(): Int =db.size
}
