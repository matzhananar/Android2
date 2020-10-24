package com.example.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var status = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.first_fragment, SecondFragment())
            .addToBackStack("initial")
            .commit()
    }


    fun onClick(view: View) {
      if (status == 0) {
          supportFragmentManager.beginTransaction()
              .replace(R.id.second_fragment, FirstFragment())
            .addToBackStack("third").commit()
            status = 1
       } else {
           supportFragmentManager.popBackStack("third", 0)
         status = 0
      }
    }
}