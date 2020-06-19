package com.example.media_app.data.repository

import com.example.media_app.chat.Constants
import com.example.media_app.chat.Constants.COLLECTION_USER
import com.example.media_app.chat.model.PostModel
import com.example.media_app.presentation.model.LoginModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.koin.core.inject

class PostRepository : BaseRepository {

    private val firebaseDb by inject<FirebaseFirestore>()

    suspend fun loadPostList(): Flow<List<PostModel>> {
        val request = firebaseDb
                // TODO: move to constants
                .collection("posts")
                .orderBy("creation_time_ms")
                .get()

        return flow {
            val response = request.await().toObjects(PostModel::class.java)
            emit(value = response)
        }
    }

    suspend fun firebaseGetUser(login: LoginModel): Flow<Boolean> =
            flow {
                val request = firebaseDb
                        .collection(COLLECTION_USER)
                        .whereEqualTo("email", "taras.k@gmail.com")
                        .get()
                val response = request.await()

                if (response != null) {
                    emit(true)
                }
            }
}