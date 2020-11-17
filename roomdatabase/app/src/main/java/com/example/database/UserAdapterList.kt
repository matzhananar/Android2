package com.example.database

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapterList(val user: ArrayList<User>,val context: Context):
    RecyclerView.Adapter<UserAdapterList.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.first_fragment, parent, false)

        return MyViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user: User = user.get(position)
        holder.titleText.text = user.title
        holder.statusText.text = user.status
        holder.categoryText.text = user.category

        //holder.idText.text = user.id.toString()
        //holder.descriptionText.text = user.description
       // holder.durationText.text = user.duration
    }

    class MyViewHolder(view: View, context: Context): RecyclerView.ViewHolder(view){
        var titleText: TextView = view.findViewById(R.id.title)
        var statusText: TextView = view.findViewById(R.id.status)
        var categoryText: TextView = view.findViewById(R.id.category)

        //var idText: TextView = view.findViewById(R.id.age)
        //var descriptionText: TextView = view.findViewById(R.id.position)
        //var durationText: TextView = view.findViewById(R.id.position)

        init{
            view.setOnClickListener{
                Toast.makeText(context, statusText.text, Toast.LENGTH_SHORT).show()
            }

        }
    }
}