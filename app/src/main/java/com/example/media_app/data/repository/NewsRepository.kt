package com.example.media_app.data.repository

import com.example.media_app.data.network.dto.tmp.TopHeadline
import com.example.media_app.data.network.retrofit.service.TopHeadlineService
import com.example.media_app.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class NewsRepository : BaseRepository {

    private val newsService by inject<TopHeadlineService>()

    fun loadNewsList(
            onSuccess: (TopHeadline) -> Unit,
            onError: (e: Exception) -> Unit,
            onProgress: (Boolean) -> Unit
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                onProgress(true)
                val newsResponse = newsService.getTopHeadlineList(Constants.COUNTRY_US)
                onProgress(false)
                onSuccess(newsResponse)
            } catch (e: Exception) {
                onProgress(false)
                onError(e)
            }
        }
    }
}