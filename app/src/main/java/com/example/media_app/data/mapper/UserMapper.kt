package com.example.media_app.data.mapper

import com.example.media_app.presentation.model.User
import com.google.firebase.auth.FirebaseUser

fun mapToUser(user: FirebaseUser) = User(
        id = user.uid,
        email = user.email,
        photoUrl = user.photoUrl.toString(),
        phoneNumber = user.phoneNumber
)