package com.example.media_app.di

import com.example.media_app.data.network.retrofit.service.TopHeadlineService
import com.example.media_app.data.repository.NewsRepository
import com.example.media_app.presentation.activity.main.MainViewModel
import com.example.media_app.presentation.favorite.FavoriteViewModel
import com.example.media_app.presentation.home.HomeViewModel
import com.example.media_app.presentation.login.LoginViewModel
import com.example.media_app.presentation.news.NewsViewModel
import com.example.media_app.presentation.search.SearchViewModel
import com.example.media_app.presentation.splash.SplashViewModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "base_url"
private const val API_KEY = "api_key"

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { LoginViewModel() }
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { NewsViewModel() }
    viewModel { SearchViewModel() }
    viewModel { FavoriteViewModel() }
}

val repositoryModule = module {
    single { NewsRepository() }
}

val networkModule = module {
    single(named(BASE_URL)) {
        "https://newsapi.org/"
    }
    single(named(API_KEY)) {
        "5614ba0e58894bf287985ae0672af8ee"
    }
    single {
        val client = OkHttpClient.Builder()
        client.addInterceptor { chain ->
            val request = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer ${get<String>(named(API_KEY))}")
                    .build()
            chain.proceed(request)
        }
        client.build()
    }
    single {
        GsonBuilder().create()
    }
    single {
        Retrofit.Builder()
                .baseUrl(get<String>(named(BASE_URL)))
                .addConverterFactory(GsonConverterFactory.create(get()))
                .client(get())
                .build()
    }
    single {
        get<Retrofit>().create(TopHeadlineService::class.java)
    }
}