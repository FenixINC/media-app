package com.example.media_app.chat.userlist

import androidx.lifecycle.MutableLiveData
import com.example.media_app.chat.model.UserModel
import com.example.media_app.data.repository.UserListRepository
import com.example.media_app.presentation.base.BaseViewModel
import com.example.media_app.utils.ViewModelData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.inject

class UserListViewModel : BaseViewModel() {

    private val userListRepository by inject<UserListRepository>()

    val userListLiveData = MutableLiveData<ViewModelData<List<UserModel>, Exception>>()

    fun loadUserLIst() = CoroutineScope(Dispatchers.IO).launch {
        try {
            userListRepository.loadUserList().collect { data ->
                userListLiveData.postValue(ViewModelData(data = data))
            }
        } catch (e: Exception) {
            userListLiveData.postValue(ViewModelData.error(error = e))
        }
    }
}