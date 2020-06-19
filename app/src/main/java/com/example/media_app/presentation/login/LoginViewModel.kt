package com.example.media_app.presentation.login

import androidx.lifecycle.MutableLiveData
import com.example.media_app.data.repository.LoginRepository
import com.example.media_app.presentation.base.BaseViewModel
import com.example.media_app.presentation.model.LoginModel
import com.example.media_app.utils.ViewModelData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.inject

class LoginViewModel : BaseViewModel() {

    private val loginRepository by inject<LoginRepository>()

    val loginLiveData = MutableLiveData<ViewModelData<Boolean, Exception>>()

    fun firebaseAuthLogin(login: LoginModel) = CoroutineScope(Dispatchers.IO).launch {
        try {
            loginRepository.firebaseAuthLogin(login = login).collect { data ->
                loginLiveData.postValue(ViewModelData(data = data))
            }

//            loginRepository.firebaseGetUser(login = login).collect { data ->
//                loginLiveData.postValue(ViewModelData(data = data))
//            }
        } catch (e: Exception) {
            loginLiveData.postValue(ViewModelData(error = e))
        }
    }
}