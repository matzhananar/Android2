package com.example.lab6retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.nav_host_fragment).navigateUp()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todo = mutableListOf<Todo>()
        for(i in 0..200){
            todo.add(Todo(false, i,"write a message", i+1))
        }

        val todoListAdapter = TodoListAdapter(todo as ArrayList<Todo>, this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = todoListAdapter

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(APIService::class.java)


        apiService.getTodos().enqueue(object : Callback<List<Todo>> {

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.e("Error", "dct pft,fkb")
            }
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                Log.e("Response size: ", response.body()!!.size.toString() + "")
                todo.addAll(response.body()!!)
            }
        })

        apiService.getTodoById(66).enqueue(object : Callback<Todo> {
            override fun onFailure(call: Call<Todo>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                Log.e("Todo title: ", response.body()!!.id.toString() + "")
            }
        })
    }
}

