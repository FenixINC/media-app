package com.example.media_app.chat.chatting

import android.os.Bundle
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class ChatFragment : BaseFragment<ChatViewModel>() {

    override val viewModel by inject<ChatViewModel>()

    override fun getLayoutRes() = R.layout.fragment_chat

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}