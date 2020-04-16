package com.example.media_app.presentation.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.example.media_app.presentation.model.AppConfig
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseViewModel : ViewModel(), KoinComponent, LifecycleObserver {
    val appConfig by inject<AppConfig>()
}