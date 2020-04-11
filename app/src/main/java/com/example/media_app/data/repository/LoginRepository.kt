package com.example.media_app.data.repository

import com.example.media_app.data.database.dao.LoginDao
import com.example.media_app.data.database.entity.LoginEntity
import com.example.media_app.data.mapper.mapToLoginEntity
import com.example.media_app.presentation.model.LoginModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class LoginRepository : BaseRepository {

    private val loginDao by inject<LoginDao>()

    fun getUser(login: LoginModel, onSuccess: (Boolean) -> Unit, onError: (e: Exception) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                loginDao.getUser(login.email, login.password)
                onSuccess(true)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    fun saveUser(
            login: LoginModel,
            onSuccess: (LoginModel) -> Unit,
            onError: (e: Exception) -> Unit,
            onProgress: (Boolean) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                loginDao.insert(login.mapToLoginEntity())
                onSuccess(login)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    fun deleteUser(onSuccess: (LoginEntity) -> Unit, onError: (e: Exception) -> Unit, onProgress: (Boolean) -> Unit) {

    }
}