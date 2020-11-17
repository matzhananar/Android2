package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.database.Fragments.FirstFragment
import com.example.database.Fragments.NewFragment

class MainActivity : AppCompatActivity() {

    var status = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MyApplication.instance.getDatabase()!!
        userDao = db.UserDao()

        list = userDao.getAll()

        instance = this

        supportFragmentManager.beginTransaction()
            .add(R.id.container, FirstFragment())
            .commit()

    }

    fun onClick(view: View) {
        if (view.id == R.id.newList) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, NewFragment())
                    .addToBackStack(null)
                    .commit()
            }

        else if (view.id == R.id.backtolist)
        {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FirstFragment())
                    .addToBackStack(null)
                    .commit()
        }

        else if(view.id == R.id.recyclerview)
        {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment())
                .addToBackStack(null)
                .commit()
        }
        }



    companion object {
        lateinit var list: MutableList<User>
        lateinit var db: AppDatabase
        lateinit var userDao: UserDao
        lateinit var instance: MainActivity

        fun createUser(user: User) {
            user.id = userDao.insert(user)
            list.add(user)
            instance.supportFragmentManager.popBackStack()
        }
    }
}