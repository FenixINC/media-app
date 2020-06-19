package com.example.media_app.chat.post

import androidx.lifecycle.MutableLiveData
import com.example.media_app.chat.model.PostModel
import com.example.media_app.data.repository.PostRepository
import com.example.media_app.presentation.base.BaseViewModel
import com.example.media_app.presentation.model.LoginModel
import com.example.media_app.utils.ViewModelData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.inject

class PostViewModel : BaseViewModel() {

    private val postRepository by inject<PostRepository>()

    val postLiveData = MutableLiveData<ViewModelData<List<PostModel>, Exception>>()

    fun loadPostList() = CoroutineScope(Dispatchers.IO).launch {
        try {
            postRepository.loadPostList().collect { data ->
                postLiveData.postValue(ViewModelData(data = data))
            }
        } catch (e: Exception) {
//            postLiveData.postValue(ViewModelData.error(error = e))
        }
    }

    fun getUser(login: LoginModel) = CoroutineScope(Dispatchers.IO).launch {
        try {
            postRepository.firebaseGetUser(login = login).collect { data ->
//                postLiveData.postValue(ViewModelData(data = data))
            }
        } catch (e: Exception) {
            val error = e
        }
    }
}