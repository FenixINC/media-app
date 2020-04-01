package com.example.media_app.data.network.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val header = request.headers.newBuilder().add("Authorization", "5614ba0e58894bf287985ae0672af8ee").build()
        val url = request.url.newBuilder().addQueryParameter("", "").build()
        request = request.newBuilder().url(header.toString()).build()
        return chain.proceed(request)
    }
}