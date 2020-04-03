package com.example.media_app.presentation.home

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.media_app.presentation.base.BaseViewModel

class HomeViewModel : BaseViewModel() {

    val textLiveData = MutableLiveData<String>()

    var someText = ObservableField<String>()

    fun changeText(text: String) {
        textLiveData.postValue(text)
    }

    fun updateTextResult() {

    }
}