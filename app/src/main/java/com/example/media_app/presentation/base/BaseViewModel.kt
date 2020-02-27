package com.example.media_app.presentation.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent, LifecycleObserver