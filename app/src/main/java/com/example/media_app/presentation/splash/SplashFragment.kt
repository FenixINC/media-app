package com.example.media_app.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.media_app.R
import com.example.media_app.presentation.activity.main.HomeActivity
import com.example.media_app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*
import org.koin.android.ext.android.inject

class SplashFragment : BaseFragment<SplashViewModel>() {

    override val viewModel by inject<SplashViewModel>()

    override fun getLayoutRes() = R.layout.fragment_splash

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_navigate_to_home_activity.setOnClickListener {
            startActivity(Intent(activity, HomeActivity::class.java))
            activity?.finish()
        }
        btn_navigate_to_login.setOnClickListener {
            findNavController().navigate(R.id.action_splash_to_login)
        }
    }
}