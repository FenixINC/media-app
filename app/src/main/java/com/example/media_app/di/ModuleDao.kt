package com.example.media_app.di

import com.example.media_app.data.database.AppDatabase
import org.koin.dsl.module

val daoModule = module {
    single { get<AppDatabase>().characterDao() }
}