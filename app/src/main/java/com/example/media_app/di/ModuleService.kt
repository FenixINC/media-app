package com.example.media_app.di

import com.example.media_app.data.network.retrofit.service.CharacterService
import com.example.media_app.data.network.retrofit.service.TopHeadlineService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { get<Retrofit>().create(TopHeadlineService::class.java) }
    single { get<Retrofit>().create(CharacterService::class.java) }
}