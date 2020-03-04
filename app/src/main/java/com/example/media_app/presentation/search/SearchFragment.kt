package com.example.media_app.presentation.search

import android.os.Bundle
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class SearchFragment : BaseFragment<SearchViewModel>() {

    override val viewModel by inject<SearchViewModel>()

    override fun getLayoutRes() = R.layout.fragment_search

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        activity?.finish()
    }
}