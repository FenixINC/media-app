package com.example.media_app.di

import com.example.media_app.presentation.model.AppConfig
import org.koin.dsl.module

val configModule = module {
    single { AppConfig() }
}