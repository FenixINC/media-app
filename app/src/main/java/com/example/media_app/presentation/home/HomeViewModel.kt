package com.example.media_app.presentation.home

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.media_app.data.network.dto.CharacterResponse
import com.example.media_app.data.repository.CharacterRepository
import com.example.media_app.presentation.base.BaseViewModel
import com.example.media_app.utils.ViewModelData
import org.koin.core.inject

class HomeViewModel : BaseViewModel() {

    private val characterRepository by inject<CharacterRepository>()

    val characterLiveData = MutableLiveData<ViewModelData<List<CharacterResponse>, Exception, Boolean>>()

    val textLiveData = MutableLiveData<String>()

    var someText = ObservableField<String>()

    fun changeText(text: String) {
        textLiveData.postValue(text)
    }

    fun updateTextResult() {

    }

    fun loadAllCharacters() = characterRepository.loadAllCharacters(
            { characterLiveData.postValue(ViewModelData(data = it)) },
            { characterLiveData.postValue(ViewModelData.error(error = it)) },
            { characterLiveData.postValue(ViewModelData.progress(progress = it)) }
    )

    fun ktorLoadAllCharacters() = characterRepository.ktorLoadAllCharacters(
            { characterLiveData.postValue(ViewModelData(data = it)) },
            { characterLiveData.postValue(ViewModelData.error(error = it)) },
            { characterLiveData.postValue(ViewModelData.progress(progress = it)) }
    )
}