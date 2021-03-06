package com.example.media_app.di

import com.example.media_app.data.repository.CharacterRepository
import com.example.media_app.data.repository.LoginRepository
import com.example.media_app.data.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LoginRepository() }
    single { NewsRepository() }
    single { CharacterRepository() }
}