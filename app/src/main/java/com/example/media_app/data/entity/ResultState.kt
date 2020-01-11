package com.example.media_app.data.entity

sealed class ResultState<out T> {
    class Loading<out T> : ResultState<T>() //--- showing progress
    class Success<out T>(val data: T) : ResultState<T>() //--- success retrieve data
    class Error<out T>(error: String) : ResultState<T>() //--- getting error from server
    class Failure<out T>(val throwable: Throwable) : ResultState<T>() //--- unexpected happen
}