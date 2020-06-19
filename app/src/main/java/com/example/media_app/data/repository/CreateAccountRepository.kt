package com.example.media_app.data.repository

import com.example.media_app.chat.Constants
import com.example.media_app.presentation.model.LoginModel
import com.example.media_app.presentation.model.User
import com.example.media_app.presentation.model.UserRole
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.koin.core.inject
import java.util.*

class CreateAccountRepository : BaseRepository {

    private val firebaseDb by inject<FirebaseFirestore>()

    suspend fun firebaseCreateUser(login: LoginModel): Flow<Boolean> =
            flow {
                val user = User(
                        id = UUID.randomUUID().toString(),
                        username = login.email,
                        email = login.email,
                        password = login.password,
//                        age = 20,
//                        phoneNumber = "some number",
//                        photoUrl = "some url",
                        role = UserRole.USER
                )
                val request = firebaseDb
                        .collection(Constants.COLLECTION_USER)
                        .document()
                        .set(user)
                val response = request.await()

                if (response != null) {
                    emit(true)
                }
            }
}