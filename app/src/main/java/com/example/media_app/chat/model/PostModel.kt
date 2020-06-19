package com.example.media_app.chat.model

import com.google.firebase.firestore.PropertyName

data class PostModel(
    @get: PropertyName("creation_time_ms") @set: PropertyName("creation_time_ms") var creationTimeMs: Long? = 0L,
    @get: PropertyName("description") @set: PropertyName("description") var description: String? = "",
    @get: PropertyName("image_url") @set: PropertyName("image_url") var imageUrl: String? = "",
    @get: PropertyName("user") @set: PropertyName("user") var user: UserModel? = null
)