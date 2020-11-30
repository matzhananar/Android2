package com.example.lab6retrofit

import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @GET("todos/")
    fun getTodos(): Call<List<Todo>>

    @GET("todos/{id}/")
    fun getTodoById(@Path("id") todoId: Int): Call<Todo>

}