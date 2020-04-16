package com.example.media_app.data.repository

import com.example.media_app.data.mapper.mapToUser
import com.example.media_app.presentation.model.LoginModel
import com.example.media_app.presentation.model.User
import com.example.media_app.utils.ViewModelData
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class LoginRepository : BaseRepository {

    suspend fun firebaseLogin(login: LoginModel): ViewModelData<User, Exception, Boolean> =
            suspendCoroutine { continuation ->
                FirebaseAuth.getInstance()
                        .signInWithEmailAndPassword(login.email, login.password)
                        .addOnCompleteListener { task ->
                            when {
                                task.isSuccessful -> {
                                    task.result?.user?.let { user ->
                                        mapToUser(user).run {
                                            continuation.resume(ViewModelData(this))
                                        }
                                    }
                                            ?: continuation.resumeWithException(Exception(task.exception?.message))
                                }
                                else -> {
                                    continuation.resumeWithException(Exception(task.exception?.message))
                                }
                            }
                        }
            }
}