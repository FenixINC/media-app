package com.example.media_app.data.repository

import com.example.media_app.chat.Constants.COLLECTION_USER
import com.example.media_app.chat.Constants.EMAIL
import com.example.media_app.presentation.model.LoginModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.koin.core.inject

class LoginRepository : BaseRepository {

    private val firebaseAuth by inject<FirebaseAuth>()
    private val firebaseDb by inject<FirebaseFirestore>()

    suspend fun firebaseGetUser(login: LoginModel): Flow<Boolean> =
            flow {
                val request = firebaseDb
                        .collection(COLLECTION_USER)
                        .whereEqualTo(EMAIL, login.email)
                        .get()
                val response = request.await()

                if (response != null) {
                    emit(true)
                }
            }

    suspend fun firebaseAuthLogin(login: LoginModel): Flow<Boolean> =
            flow {
                val request = firebaseAuth.signInWithEmailAndPassword(login.email, login.password)
                val response = request.await()

                if (response.user != null) {
                    response.user?.let { user ->
                        emit(value = true)
                    }
                }
            }
}