package com.example.media_app.data.mapper

import com.example.media_app.data.database.entity.LoginEntity
import com.example.media_app.data.network.dto.LoginModel

fun LoginModel.mapToLoginEntity() = LoginEntity(
        email = email,
        password = password
)

fun LoginEntity.mapToLoginModel() = LoginModel(
        email = email ?: "",
        password = password ?: ""
)