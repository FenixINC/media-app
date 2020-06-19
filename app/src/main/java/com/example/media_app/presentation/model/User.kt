package com.example.media_app.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
        val id: String? = null,
        val username: String? = null,
        val email: String? = null,
        val password: String? = null,
        val age: Int? = 0,
        val photoUrl: String? = null,
        val phoneNumber: String? = null,
        val role: UserRole? = null
) : Parcelable