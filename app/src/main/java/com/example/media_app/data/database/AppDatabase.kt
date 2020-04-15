package com.example.media_app.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.media_app.data.database.dao.CharacterDao
import com.example.media_app.data.database.dao.LoginDao
import com.example.media_app.data.database.entity.CharacterEntity
import com.example.media_app.data.database.entity.LoginEntity
import com.example.media_app.presentation.MediaApplication

@Database(
        entities = [
            (LoginEntity::class),
            (CharacterEntity::class)
        ],
        version = 1,
        exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loginDao(): LoginDao
    abstract fun characterDao(): CharacterDao

//    companion object {
//
//        @Volatile
//        private var instance: AppDatabase? = null
//
//        fun getInstance(): AppDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase().also { instance = it }
//            }
//        }
//
//        private fun buildDatabase(): AppDatabase =
//                Room.databaseBuilder(
//                        MediaApplication.getAppInstance,
//                        AppDatabase::class.java,
//                        ""
//                ).build()
//    }
}