package com.example.lab6retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(val todo: ArrayList<Todo>, val context: Context):
    RecyclerView.Adapter<TodoListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.listoftasks, parent, false)

        return MyViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return todo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todo: Todo = todo.get(position)
        //holder.userIdText.text = todo.userId.toString()
        //  holder.idText.text = todo.id.toString()
        holder.titleText.text = todo.title
        holder.completedText.text = todo.completed.toString()
    }

    class MyViewHolder(view: View, context: Context): RecyclerView.ViewHolder(view){
        var titleText: TextView = view.findViewById(R.id.title)
        var completedText: TextView = view.findViewById(R.id.status)
      //  var idText: TextView = view.findViewById(R.id.id)
        //  var userIdText: TextView = view.findViewById(R.id.user)

        init {
            view.setOnClickListener {

                Toast.makeText(context, "sorry i dont know fragments", Toast.LENGTH_LONG).show()
                it.findNavController().navigate(R.id.action_listOfTasks_to_detailOfTask)

            }

        }
    }
}