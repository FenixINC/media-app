package com.example.media_app.chat.model

import com.google.firebase.firestore.PropertyName

data class MessageModel(
    @get: PropertyName("id") @set: PropertyName("id") var id: String? = "",
    @get: PropertyName("message_type") @set: PropertyName("message_type") var messageType: String? = "",
    @get: PropertyName("user") @set: PropertyName("user") var user: UserModel? = null
)