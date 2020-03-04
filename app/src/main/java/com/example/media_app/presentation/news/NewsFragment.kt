package com.example.media_app.presentation.news

import android.os.Bundle
import androidx.activity.addCallback
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class NewsFragment : BaseFragment<NewsViewModel>() {

    override val viewModel by inject<NewsViewModel>()

    override fun getLayoutRes() = R.layout.fragment_news

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.header_news)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        activity?.finish()
    }
}