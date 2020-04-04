package com.example.media_app.di

import androidx.room.Room
import com.example.media_app.data.database.AppDatabase
import com.example.media_app.presentation.MediaApplication
import org.koin.dsl.module

private const val DATABASE_NAME = "The-Breaking-Bad-Database"

val databaseModule = module {
    single { provideDatabase() }
}

private fun provideDatabase(): AppDatabase =
        Room.databaseBuilder(MediaApplication.getAppInstance, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()