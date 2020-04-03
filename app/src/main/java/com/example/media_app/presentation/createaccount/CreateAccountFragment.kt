package com.example.media_app.presentation.createaccount

import android.os.Bundle
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import com.example.media_app.presentation.base.BaseViewModel
import org.koin.android.ext.android.inject

class CreateAccountFragment : BaseFragment<BaseViewModel>() {

    override val viewModel by inject<BaseViewModel>()

    override fun getLayoutRes() = R.layout.fragment_create_account

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.header_news)
    }
}