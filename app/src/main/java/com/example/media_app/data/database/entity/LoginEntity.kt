package com.example.media_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TABLE_LOGIN")
data class LoginEntity(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int? = 0,
        @ColumnInfo(name = "email") var email: String? = "",
        @ColumnInfo(name = "password") var password: String? = ""
)