package com.example.media_app.presentation.search

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.ext.android.inject

class SearchFragment : BaseFragment<SearchViewModel>() {

    override val viewModel by inject<SearchViewModel>()

    override fun getLayoutRes() = R.layout.fragment_search

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_item_details.setOnClickListener {
            findNavController().navigate(R.id.action_search_to_item_details)
        }
    }
}