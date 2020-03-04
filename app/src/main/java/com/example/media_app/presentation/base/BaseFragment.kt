package com.example.media_app.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

abstract class BaseFragment<VM : BaseViewModel> : Fragment(), LifecycleOwner {

//    private lateinit var onBackPressedCallback: OnBackPressedCallback

    protected abstract val viewModel: VM
    protected lateinit var binding: ViewDataBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        return binding.root
    }

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

//    override fun onStart() {
//        super.onStart()
//        setBackButtonDispatcher()
//    }

//    override fun onStop() {
//        super.onStop()
//        onBackPressedCallback.remove()
//    }

//    private fun setBackButtonDispatcher() {
//        onBackPressedCallback = object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
////                onBackPressed()
//            }
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
//    }

//    protected open fun onBackPressed() {}
}