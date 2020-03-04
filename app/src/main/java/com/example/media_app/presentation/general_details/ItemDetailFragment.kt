package com.example.media_app.presentation.general_details

import android.os.Bundle
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class ItemDetailFragment : BaseFragment<ItemDetailsViewModel>() {

    override val viewModel by inject<ItemDetailsViewModel>()

    override fun getLayoutRes() = R.layout.fragment_item_details

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.header_item_details)
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//    }
}