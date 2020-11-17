package com.example.database

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): MutableList<User>

    @Delete
    fun delete(task: User)

    @Update
    fun update(task: User)

    @Insert
    fun insert(task: User): Long

}