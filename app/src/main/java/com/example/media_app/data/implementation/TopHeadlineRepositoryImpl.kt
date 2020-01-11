package com.example.media_app.data.implementation

import androidx.lifecycle.MutableLiveData
import com.example.media_app.data.entity.ResultState
import com.example.media_app.data.entity.TopHeadline
import com.example.media_app.data.network.ServiceGenerator
import com.example.media_app.data.network.service.TopHeadlineService
import com.example.media_app.domain.repository.TopHeadlineRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class TopHeadlineRepositoryImpl : TopHeadlineRepository {

    private var mMutableLiveData = MutableLiveData<ResultState<TopHeadline>>()

    private val mService by lazy {
        ServiceGenerator.createService(TopHeadlineService::class.java)
    }

    override fun doLoadTopHeadlineList(scope: CoroutineScope): MutableLiveData<ResultState<TopHeadline>> {
        scope.launch(Dispatchers.Main) {
            val request = mService.getTopHeadlineList("us")

            withContext(Dispatchers.IO) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        response.body()?.let { list ->
                            withContext(Dispatchers.Main) {
                                mMutableLiveData.value = ResultState.Success(list)
                            }
                        }
                    }
                } catch (e: Exception) {
                    Timber.e(e)
                    withContext(Dispatchers.Main) {
                        mMutableLiveData.value = ResultState.Failure(throwable = e)
                    }
                }
            }
        }
        return mMutableLiveData
    }
}