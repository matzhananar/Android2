package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "user")
data class User(
    @PrimaryKey var id: Long? = null,
    @ColumnInfo(name = "title") var title: String? = null,
    @ColumnInfo(name = "description") var description: String? = null,
    @ColumnInfo(name = "status") var status: String? = null,
    @ColumnInfo(name = "category") var category: String? = null,
    @ColumnInfo(name = "duration") var duration: String? = null
)
