package com.example.media_app.data.network.retrofit

import com.example.media_app.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

object ServiceGenerator {

    private val httpClient: OkHttpClient.Builder
    private val builder: Retrofit.Builder

    init {

        Timber.d("[API BASE URL] %s", BuildConfig.API_BASE_URL)

        val apiBaseUrl = BuildConfig.API_BASE_URL
        val apiKey = "5614ba0e58894bf287985ae0672af8ee"

        httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder()
//                .addHeader("DEVICE-OS", "ANDROID")
//                .addHeader("DEVICE-OS-VERSION", Build.VERSION.RELEASE)
//                .addHeader("DEVICE-GENERAL-INFO", Build.MODEL)
                .addHeader("Authorization", "Bearer $apiKey")
                .build()
            chain.proceed(request)
        }

        builder = Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
    }

    fun <S> createService(serviceClass: Class<S>): S {
        Timber.d("Call <%s>", serviceClass.simpleName)
        val client = httpClient
            .build()
        val retrofit = builder
            .client(client)
            .build()
        return retrofit.create(serviceClass)
    }
}