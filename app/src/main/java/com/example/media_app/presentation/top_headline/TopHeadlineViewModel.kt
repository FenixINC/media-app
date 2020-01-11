package com.example.media_app.presentation.top_headline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.media_app.domain.repository.TopHeadlineRepository
import kotlinx.coroutines.CoroutineScope

class TopHeadlineViewModel() : ViewModel() {

    private var mRepository: TopHeadlineRepository? = null

    constructor(repository: TopHeadlineRepository) : this() {
        mRepository = repository
    }

    fun loadTopHeadlineList(scope: CoroutineScope) = mRepository?.doLoadTopHeadlineList(scope)

    @Suppress("UNCHECKED_CAST")
    class Factory(private val repository: TopHeadlineRepository) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TopHeadlineViewModel(repository) as T
        }
    }
}