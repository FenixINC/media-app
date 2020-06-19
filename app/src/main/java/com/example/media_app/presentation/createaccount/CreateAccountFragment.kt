package com.example.media_app.presentation.createaccount

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import com.example.media_app.presentation.model.LoginModel
import kotlinx.android.synthetic.main.fragment_create_account.*
import org.koin.android.ext.android.inject

class CreateAccountFragment : BaseFragment<CreateAccountViewModel>() {

    override val viewModel by inject<CreateAccountViewModel>()

    override fun getLayoutRes() = R.layout.fragment_create_account

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_create_account.setOnClickListener {
//            showLoading()
            val email = edit_email.text.toString()
            val password = edit_password.text.toString()
            val login = LoginModel(email = email, password = password)

            viewModel.firebaseUserCreate(login = login)
        }

        viewModel.createAccountLiveData.observe(viewLifecycleOwner, Observer { data ->
            //TODO: return back to login screen
            hideLoading()
            parentFragmentManager.popBackStack()
        })
    }
}