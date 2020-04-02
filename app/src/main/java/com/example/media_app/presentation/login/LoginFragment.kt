package com.example.media_app.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.media_app.R
import com.example.media_app.presentation.main.MainActivity
import com.example.media_app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment<LoginViewModel>() {

    override val viewModel by inject<LoginViewModel>()

    override fun getLayoutRes() = R.layout.fragment_login

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_login.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
        }

        btn_create_account.setOnClickListener {
//            findNavController().navigate(R.id.action_login_to_create_account)
        }
    }


}