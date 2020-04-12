package com.example.media_app.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.media_app.utils.ResultState
import com.example.media_app.data.network.dto.tmp.TopHeadline
import kotlinx.coroutines.CoroutineScope

interface TopHeadlineRepository {
    fun doLoadTopHeadlineList(scope: CoroutineScope): MutableLiveData<ResultState<TopHeadline>>
}