package com.example.media_app.presentation.news

import androidx.lifecycle.MutableLiveData
import com.example.media_app.data.network.dto.tmp.TopHeadline
import com.example.media_app.data.repository.NewsRepository
import com.example.media_app.presentation.base.BaseViewModel
import com.example.media_app.utils.ViewModelData
import org.koin.core.inject

class NewsViewModel : BaseViewModel() {

    private val newsRepository by inject<NewsRepository>()

    val newsData = MutableLiveData<ViewModelData<TopHeadline, Exception, Boolean>>()

    fun loadNews() = newsRepository.loadNewsList(
            { newsData.postValue(ViewModelData(data = it)) },
            { newsData.postValue(ViewModelData.error(error = it)) },
            { newsData.postValue(ViewModelData.progress(progress =  it)) }
    )
}