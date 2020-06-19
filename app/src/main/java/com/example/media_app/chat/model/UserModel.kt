package com.example.media_app.chat.model

import com.example.media_app.presentation.model.UserRole
import com.google.firebase.firestore.PropertyName

data class UserModel(
    @get: PropertyName("id") @set: PropertyName("id") var id: String? = "",
    @get: PropertyName("age") @set: PropertyName("age") var age: Int? = 0,
    @get: PropertyName("username") @set: PropertyName("username") var username: String? = "",
    @get: PropertyName("email") @set: PropertyName("email") var email: String? = "",
    @get: PropertyName("password") @set: PropertyName("password") var password: String? = "",
    @get: PropertyName("photo_url") @set: PropertyName("photo_url") var photoUrl: String? = "",
    @get: PropertyName("phone_number") @set: PropertyName("phone_number") var phoneNumber: String? = "",
    @get: PropertyName("user_role") @set: PropertyName("user_role") var userRole: UserRole? = UserRole.USER
)