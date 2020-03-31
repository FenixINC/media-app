package com.example.media_app

import com.example.media_app.data.network.retrofit.service.TopHeadlineService
import com.example.media_app.di.networkModule
import com.google.gson.Gson
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import retrofit2.Retrofit

class NetworkTest : KoinTest {

    private val newsApi: TopHeadlineService by inject()
    private val retrofit: Retrofit by inject()
    private val okHttpClient: OkHttpClient by inject()
    private val gson: Gson by inject()

    private val baseUrl: String by lazy { get(named("base_url")) as String }
    private val apiKey: String by lazy { get(named("api_key")) as String }

    @Before
    fun setup() {
        startKoin {
            modules(listOf(networkModule))
        }
    }

    @Test
    fun testRetrofit() {
        assertNotNull(retrofit)
        assert(baseUrl == "https://newsapi.org/")
    }

    @Test
    fun testGson() {
        assertNotNull(gson)
    }

    @Test
    fun testNewsApi() {
        assertNotNull(newsApi)
    }

    @Test
    fun testOkHttp() {
        assertNotNull(okHttpClient)
//        assertTrue(okHttpClient.connectTimeoutMillis == 30000)
//        assertTrue(okHttpClient.writeTimeoutMillis == 30000)
//        assertTrue(okHttpClient.readTimeoutMillis == 30000)
        assertTrue(okHttpClient.interceptors.size == 1)
    }

    @After
    fun stop() {
        stopKoin()
    }
}