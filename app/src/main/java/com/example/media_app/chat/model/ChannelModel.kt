package com.example.media_app.chat.model

import com.google.firebase.firestore.PropertyName

data class ChannelModel(
    @get: PropertyName("id") @set: PropertyName("id") var id: String? = "",
    @get: PropertyName("channel_type") @set: PropertyName("channel_type") var channelType: String? = "" // One to One; Group chat
)