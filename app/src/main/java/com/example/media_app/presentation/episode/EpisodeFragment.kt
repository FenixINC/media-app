package com.example.media_app.presentation.episode

import android.os.Bundle
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class EpisodeFragment : BaseFragment<EpisodeViewModel>() {

    override val viewModel by inject<EpisodeViewModel>()

    override fun getLayoutRes() = R.layout.fragment_episode

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}