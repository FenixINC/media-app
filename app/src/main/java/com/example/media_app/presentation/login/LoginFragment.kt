package com.example.media_app.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import com.example.media_app.presentation.main.MainActivity
import com.example.media_app.presentation.model.LoginModel
import com.example.media_app.utils.hideKeyboard
import com.example.media_app.utils.showSnackbarLong
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment<LoginViewModel>() {

    override val viewModel by inject<LoginViewModel>()

    override fun getLayoutRes() = R.layout.fragment_login

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createAccountClick()
        loginClick()
        loginObserve()
    }

    private fun createAccountClick() {
        btn_create_account.setOnClickListener {
            hideKeyboard()
            findNavController().navigate(R.id.action_login_to_create_account)
        }
    }

    private fun loginClick() {
        btn_login.setOnClickListener {
            hideKeyboard()
            showLoading()
            val login = LoginModel(email = email_field.text.toString(), password = password_field.text.toString())
            viewModel.firebaseAuthLogin(login = login)
        }
    }

    private fun loginObserve() {
        viewModel.loginLiveData.observe(viewLifecycleOwner, Observer { result ->
            hideLoading()
            if (result.data != null) {
                startActivity(Intent(activity, MainActivity::class.java))
                activity?.finish()
            }
            if (result.error != null) {
                showSnackbarLong(requireView(), result.error.message.toString())
            }
        })
    }
}