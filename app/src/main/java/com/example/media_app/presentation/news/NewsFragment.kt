package com.example.media_app.presentation.news

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.ext.android.inject

class NewsFragment : BaseFragment<NewsViewModel>() {

    override val viewModel by inject<NewsViewModel>()

    override fun getLayoutRes() = R.layout.fragment_news

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_item_details.setOnClickListener {
            findNavController().navigate(R.id.action_news_to_item_details)
        }
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        activity?.finish()
//    }
}