package com.example.media_app.data.network.graphql

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

object GraphQlGenerator {

    val apolloClient: ApolloClient = setupApollo()

//    private fun createApolloClient(): ApolloClient {
//        val apiBaseUrl = "https://rickandmortyapi.com/graphql/"
//        val apiKey = "f35e42d2-f764-4f88-8805-afdb5b12018b"
//
////        httpClient = OkHttpClient.Builder()
////        httpClient.addInterceptor { chain ->
////            val request = chain.request().newBuilder()
////                .addHeader("x-api-key", apiKey)
////                .build()
////            chain.proceed(request)
////        }
//
//
//        val builder: ApolloClient.Builder
//
//        val httpClient = OkHttpClient.Builder()
//            .addInterceptor { chain ->
//                chain.proceed(
//                    chain.request().newBuilder()
//                        .addHeader("x-api-key", apiKey)
//                        .build()
//                )
//            }
//            .build()
//
//        return ApolloClient.builder()
//            .serverUrl(apiBaseUrl)
//            .callFactory { request ->
//                httpClient.newCall(request)
//            }
//
////        ApolloClient
////            .builder()
////            .serverUrl("https://graphql.contentful.com/")
////            .callFactory { request ->
////                httpClient.newCall(request)
////            }
////            .build()
//    }

    private fun setupApollo(): ApolloClient {
        val apiBaseUrl = "https://rickandmortyapi.com/graphql/"
        val apiKey = "f35e42d2-f764-4f88-8805-afdb5b12018b"

        val okHttp = OkHttpClient
            .Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder().method(
                    original.method(),
                    original.body()
                )
                builder
                    .addHeader("x-api-key", apiKey)
                chain.proceed(builder.build())
            }
            .build()

        return ApolloClient.builder()
            .serverUrl(apiBaseUrl)
            .okHttpClient(okHttp)
            .build()
    }
}