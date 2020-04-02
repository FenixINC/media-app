package com.example.media_app.presentation.splash

import android.content.Intent
import android.os.Bundle
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import com.example.media_app.presentation.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class SplashFragment : BaseFragment<SplashViewModel>() {

    override val viewModel by inject<SplashViewModel>()

    override fun getLayoutRes() = R.layout.fragment_splash

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            delay(2500L)
            startActivity(Intent(context, MainActivity::class.java))
            activity?.finish()
        }
    }
}