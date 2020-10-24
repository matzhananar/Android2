package com.example.midterm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserListAdapter(val user: ArrayList<User>, val context: Context):
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user: User = user.get(position)
        holder.IDText.text = user.ID.toString()
        holder.titleText.text = user.title
        holder.descriptionText.text = user.description
        holder.statusText.text = user.status
        holder.categoryText.text = user.category
        holder.durationText.text = user.duration.toString()
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        var IDText: TextView = view.findViewById(R.id.ID)
        var titleText: TextView = view.findViewById(R.id.title)
        var descriptionText: TextView = view.findViewById(R.id.description)
        var statusText: TextView = view.findViewById(R.id.status)
        var categoryText: TextView = view.findViewById(R.id.category)
        var durationText: TextView = view.findViewById(R.id.duration)

    }
}