package com.example.media_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TABLE_CHARACTER")
data class CharacterEntity(
        @PrimaryKey @ColumnInfo(name = "id") var id: Int? = 0,
        @ColumnInfo(name = "name") var name: String? = "",
        @ColumnInfo(name = "imageUrl") var imageUrl: String? = "",
        @ColumnInfo(name = "status") var status: String? = "",
        @ColumnInfo(name = "nickname") var nickname: String? = "",
        @ColumnInfo(name = "birthday") var birthday: String? = "",
        @ColumnInfo(name = "portrayed") var portrayed: String? = "",
        @ColumnInfo(name = "category") var category: String? = ""
)