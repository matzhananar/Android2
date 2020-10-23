package com.example.labfragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("myPreference", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "")
        if(username!!.isNotEmpty()!!){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        setContentView(R.layout.activity_login)
    }

    fun onClick(view: View) {
        val username = user_name.text.toString()
        val password = pass_word.text.toString()

        if(username.isNotEmpty() and password.isNotEmpty()){
            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.putString("password", password)
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}