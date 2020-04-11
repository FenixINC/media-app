package com.example.media_app.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.media_app.R
import com.example.media_app.presentation.model.LoginModel
import com.example.media_app.presentation.base.BaseFragment
import com.example.media_app.presentation.main.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment<LoginViewModel>() {

    override val viewModel by inject<LoginViewModel>()

    override fun getLayoutRes() = R.layout.fragment_login

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loginLiveData.observe(viewLifecycleOwner, Observer { viewModelData ->
            when {
//                viewModelData.data != null -> openHomePage()
//                viewModelData.error != null -> showSnackbarLong(requireView(), viewModelData.error.message!!)
            }
        })

        btn_login.setOnClickListener {
            //TODO: check if user exists
            val login = LoginModel(email = email.text.toString(), password = password.text.toString())
            viewModel.getUser(login = login)
        }

        btn_create_account.setOnClickListener {
            // TODO: make this in CreateAccount screen!
//            showLoading()
//            val login = LoginModel(email = email.text.toString(), password = password.text.toString())
//            viewModel.saveUser(login = login)
        }
    }

    private fun openHomePage() {
        startActivity(Intent(context, MainActivity::class.java))
        activity?.finish()
    }
}