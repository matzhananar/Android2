package com.example.labfragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.labfragments.R
import com.example.labfragments.User

class UserListAdapter(val user: ArrayList<User>, val context: Context):
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mails, parent, false)

        return MyViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user: User = user.get(position)
        holder.userText.text = user.name
        holder.titleText.text = user.position
        holder.messageText.text = user.message
    }

    class MyViewHolder(view: View, context: Context): RecyclerView.ViewHolder(view){
        var userText: TextView = view.findViewById(R.id.user)
        var titleText: TextView = view.findViewById(R.id.title)
        var messageText: TextView = view.findViewById(R.id.message)

        init{
            view.setOnClickListener{
                Toast.makeText(context, "sorry i dont know fragments", Toast.LENGTH_LONG).show()
            }

        }
    }
}