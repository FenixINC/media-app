package com.example.media_app.data.network.retrofit.service

import com.example.media_app.data.entity.TopHeadline
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlineService {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlineList(@Query("country") country: String): TopHeadline
}