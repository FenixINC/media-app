package com.example.media_app.presentation.login

import androidx.lifecycle.MutableLiveData
import com.example.media_app.data.network.dto.LoginModel
import com.example.media_app.data.repository.LoginRepository
import com.example.media_app.presentation.base.BaseViewModel
import com.example.media_app.utils.ViewModelData
import org.koin.core.inject

class LoginViewModel : BaseViewModel() {

    private val loginRepository by inject<LoginRepository>()

    val loginLiveData = MutableLiveData<ViewModelData<LoginModel, Exception, Boolean>>()

    fun getUser(login: LoginModel) = loginRepository.getUser(
            login = login,
            onSuccess = {},
            onError = {}
    )

    fun saveUser(login: LoginModel) = loginRepository.saveUser(
            login = login,
            onSuccess = { loginLiveData.postValue(ViewModelData(data = it)) },
            onError = { loginLiveData.postValue(ViewModelData.error(error = it)) },
            onProgress = { loginLiveData.postValue(ViewModelData.progress(progress = it)) }
    )
}