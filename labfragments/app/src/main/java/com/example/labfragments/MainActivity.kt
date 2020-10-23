package com.example.labfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.labfragments.R
import com.example.labfragments.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var user = ArrayList<User>()
        for(i in 1..99){
            user.add(User("Name"+i, "", "employee", 20+i))
        }

        val userListAdapter = UserListAdapter(user, this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = userListAdapter
    }
}