package com.example.media_app.presentation.home

import android.os.Bundle
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    override val viewModel by inject<HomeViewModel>()

    override fun getLayoutRes() = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        activity?.finish()
//    }
}