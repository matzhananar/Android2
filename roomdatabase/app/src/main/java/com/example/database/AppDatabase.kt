package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
//import com.example.database.UserDao.*
//import com.example.database.model.*

@Database(
    entities = [User::class], version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao() : UserDao
}