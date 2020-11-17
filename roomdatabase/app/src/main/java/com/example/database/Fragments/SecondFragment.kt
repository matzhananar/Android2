package com.example.database.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.database.MainActivity
import com.example.database.R
import com.example.database.User


class SecondFragment(val user: User): Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment, container, false)
        view.findViewById<Button>(R.id.newList).setOnClickListener(this)
        return view
    }
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.newList -> {
                val ToDoList = User()
                ToDoList.title = title.text.toString()
                ToDoList.status = status.text.toString()
                ToDoList.description = description.text.toString()
                ToDoList.category = category.text.toString()
                ToDoList.duration = duration.text.toString()
                MainActivity.createUser(User)
            }
        }
}