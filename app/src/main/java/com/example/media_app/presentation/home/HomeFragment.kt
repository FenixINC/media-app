package com.example.media_app.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.media_app.R
import com.example.media_app.databinding.FragmentHomeBinding
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    private lateinit var binding: FragmentHomeBinding

    override val viewModel by inject<HomeViewModel>()

    override fun getLayoutRes() = R.layout.fragment_home

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = viewModel

        // Two way binding
        binding.btnClick.setOnClickListener {
            viewModel.someText.set(binding.editText.text.toString())
        }
    }
}