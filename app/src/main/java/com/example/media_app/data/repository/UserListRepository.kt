package com.example.media_app.data.repository

import com.example.media_app.chat.Constants.COLLECTION_USER
import com.example.media_app.chat.model.UserModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.koin.core.inject

class UserListRepository : BaseRepository {

    private val firebaseDb by inject<FirebaseFirestore>()

    suspend fun loadUserList() = flow {
        val request = firebaseDb
            .collection(COLLECTION_USER)
            .get()
        val response = request.await()

        if (response != null) {
            emit(response.toObjects(UserModel::class.java))
        }
    }
}