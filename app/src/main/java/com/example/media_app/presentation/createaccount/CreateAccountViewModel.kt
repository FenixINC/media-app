package com.example.media_app.presentation.createaccount

import androidx.lifecycle.MutableLiveData
import com.example.media_app.data.repository.CreateAccountRepository
import com.example.media_app.presentation.base.BaseViewModel
import com.example.media_app.presentation.model.LoginModel
import com.example.media_app.utils.ViewModelData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.inject

class CreateAccountViewModel : BaseViewModel() {

    private val createAccountRepository by inject<CreateAccountRepository>()

    val createAccountLiveData = MutableLiveData<ViewModelData<Boolean, Exception>>()

    fun firebaseUserCreate(login: LoginModel) = CoroutineScope(Dispatchers.IO).launch {
        try {
            createAccountRepository.firebaseCreateUser(login = login).collect { data ->
                createAccountLiveData.postValue(ViewModelData(data = data))
            }
        } catch (e: Exception) {
            createAccountLiveData.postValue(ViewModelData.error(error = e))
        }
    }
}