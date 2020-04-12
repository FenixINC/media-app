package com.example.media_app.presentation.episode

import androidx.lifecycle.MutableLiveData
import com.example.media_app.data.network.dto.EpisodeResponse
import com.example.media_app.data.repository.EpisodeRepository
import com.example.media_app.presentation.base.BaseViewModel
import com.example.media_app.utils.ViewModelData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.ImplicitReflectionSerializer
import org.koin.core.inject

class EpisodeViewModel : BaseViewModel() {

    private val episodeRepository by inject<EpisodeRepository>()

    val episodeLiveData = MutableLiveData<ViewModelData<List<EpisodeResponse>, Exception, Boolean>>()

    @ImplicitReflectionSerializer
    fun getAllEpisodes() = CoroutineScope(Dispatchers.IO).launch {
        episodeLiveData.postValue(ViewModelData(data = episodeRepository.loadEpisodesList()))
    }
}