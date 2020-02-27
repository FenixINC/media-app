package com.example.media_app.presentation.news

import android.os.Bundle
import androidx.activity.addCallback
import com.example.media_app.R
import com.example.media_app.databinding.FragmentTopHeadlineBinding
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class NewsFragment : BaseFragment<NewsViewModel, FragmentTopHeadlineBinding>() {

    override val viewModel by inject<NewsViewModel>()

    override fun getLayoutRes() = R.layout.fragment_top_headline

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.header_top_headline)

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            //                findNavController().navigate(R.id.action_news_to_login)
            activity?.finish()
        }
    }
}