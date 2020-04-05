package com.example.media_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.media_app.data.database.dao.CharacterDao
import com.example.media_app.data.database.dao.LoginDao
import com.example.media_app.data.database.entity.CharacterEntity
import com.example.media_app.data.database.entity.LoginEntity

@Database(entities = [
    (LoginEntity::class),
    (CharacterEntity::class)
], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loginDao(): LoginDao
    abstract fun characterDao(): CharacterDao
}