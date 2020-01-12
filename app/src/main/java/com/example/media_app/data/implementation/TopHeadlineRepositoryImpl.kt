package com.example.media_app.data.implementation

import androidx.lifecycle.MutableLiveData
import com.example.media_app.data.entity.ResultState
import com.example.media_app.data.entity.TopHeadline
import com.example.media_app.data.network.ServiceGenerator
import com.example.media_app.data.network.service.TopHeadlineService
import com.example.media_app.domain.repository.TopHeadlineRepository
import com.example.media_app.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class TopHeadlineRepositoryImpl : TopHeadlineRepository {

    private var mMutableLiveData = MutableLiveData<ResultState<TopHeadline>>()

    private val mService by lazy { ServiceGenerator.createService(TopHeadlineService::class.java) }

    override fun doLoadTopHeadlineList(scope: CoroutineScope): MutableLiveData<ResultState<TopHeadline>> {
        scope.launch(Dispatchers.Main) {
            try {
                mMutableLiveData.value = ResultState.Loading()
                val response = mService.getTopHeadlineList(Constants.COUNTRY_US)
                mMutableLiveData.value = ResultState.Success(response)
            } catch (e: Exception) {
                Timber.e(e)
                mMutableLiveData.value = ResultState.Failure(throwable = e)
            }
        }
        return mMutableLiveData
    }
}