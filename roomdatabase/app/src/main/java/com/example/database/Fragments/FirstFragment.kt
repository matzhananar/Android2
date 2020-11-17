package com.example.database.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.database.R
import com.example.database.User
import com.example.database.UserAdapterList
import kotlinx.android.synthetic.main.first_fragment.*

class FirstFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.first_fragment, container, false)

        val list = view.findViewById<RecyclerView>(R.id.recyclerview)

        val userAdapterList = UserAdapterList(user, this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.adapter = userAdapterList
        recyclerview.layoutManager =layoutManager

        return view

    }

    override fun onClick(user: User) {
        this.activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.container, SecondFragment(User))
            .addToBackStack(null)
            .commit()
    }

}
