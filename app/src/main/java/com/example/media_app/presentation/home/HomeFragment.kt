package com.example.media_app.presentation.home

import android.os.Bundle
import com.example.media_app.R
import com.example.media_app.data.network.graphql.GraphQlGenerator
import com.example.media_app.presentation.base.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    override val viewModel by inject<HomeViewModel>()

    override fun getLayoutRes() = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val clientApollo = GraphQlGenerator.apolloClient

        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
//                clientApollo.query(GetCharacterListQuery)
            }
        }
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        activity?.finish()
//    }
}