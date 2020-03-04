package com.example.media_app.presentation.favorite

import android.os.Bundle
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class FavoriteFragment : BaseFragment<FavoriteViewModel>() {

    override val viewModel by inject<FavoriteViewModel>()

    override fun getLayoutRes() = R.layout.fragment_favorite

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        activity?.finish()
    }
}