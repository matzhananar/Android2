package com.example.labwork2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.min

class MainActivity : AppCompatActivity(), View.OnClickListener{

    var counter: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter = savedInstanceState?.getDouble("counter") ?: Math.random()*10

        Log.e("MainActivity", counter.toString())

        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        zero.setOnClickListener(this)
        nine.setOnClickListener(this)
        divide.setOnClickListener(this)
        sqrt.setOnClickListener(this)
        minus.setOnClickListener(this)
        plus.setOnClickListener(this)
        multiply.setOnClickListener(this)
        clear.setOnClickListener(this)
        percentage.setOnClickListener(this)
        equal.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("MainActivity", "onSaveInstanceState")
        outState.putDouble("counter", counter)
    }

    override fun onClick(v: View?) {
        var astext: String = text.text as String
        var assign: Char = '-'
        when ( v?.id ){
            clear.id -> {
                astext = "0"
            }
            one.id -> {
                if (astext=="0"){
                   astext = "1"
                }else{
                    astext+="1"
                }
            }
            two.id ->{
                if (astext=="0"){
                    astext = "2"
                }else{
                    astext+="2"
                }
            }
            three.id ->{
                if (astext=="0"){
                    astext = "3"
                }else{
                    astext+="3"
                }
            }
            four.id ->{
                if (astext=="0"){
                    astext = "4"
                }else{
                    astext+="4"
                }
            }
            five.id ->{
                if (astext=="0"){
                    astext = "5"
                }else{
                    astext+="5"
                }
            }
            six.id ->{
                if (astext=="0"){
                    astext = "6"
                }else {
                    astext += "6"
                }
            }
            seven.id ->{
                if (astext=="0"){
                    astext = "7"
                }else{
                    astext+="7"
                }
            }
            eight.id ->{
                if (astext=="0"){
                    astext = "8"
                }else{
                    astext+="8"
                }
            }
            nine.id ->{
                if (astext=="0"){
                    astext = "9"
                }else{
                    astext+="9"
                }
            }
            zero.id ->{
                if (astext=="0"){
                    astext = "0"
                }else{
                    astext+="0"
                }
            }
            plus.id -> {
                assign = '+'
                text.text = "0"
            }
            minus.id -> {
                assign = '-'
                text.text = "0"
            }
            multiply.id -> {
                assign = '*'
                text.text = "0"
            }
            divide.id -> {
                assign = '/'
                text.text = "0"
            }
            }
        }
    }
