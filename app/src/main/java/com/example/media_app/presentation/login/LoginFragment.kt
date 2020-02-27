package com.example.media_app.presentation.login

import android.os.Bundle
import android.os.Handler
import androidx.navigation.fragment.findNavController
import com.example.media_app.R
import com.example.media_app.databinding.FragmentLoginBinding
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {

    override val viewModel by inject<LoginViewModel>()

    override fun getLayoutRes() = R.layout.fragment_login

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Handler().postDelayed({
            findNavController().navigate(R.id.action_login_to_news)
        }, 1500)
    }
}