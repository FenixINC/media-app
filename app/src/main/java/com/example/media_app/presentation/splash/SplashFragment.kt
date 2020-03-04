package com.example.media_app.presentation.splash

import android.os.Bundle
import android.os.Handler
import androidx.navigation.fragment.findNavController
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class SplashFragment : BaseFragment<SplashViewModel>() {

    override val viewModel by inject<SplashViewModel>()

    override fun getLayoutRes() = R.layout.fragment_splash

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Handler().postDelayed({
            findNavController().navigate(R.id.action_splash_to_news)
        }, 1500)
    }
}