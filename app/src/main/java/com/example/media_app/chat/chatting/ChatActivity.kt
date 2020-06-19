package com.example.media_app.chat.chatting

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : BaseActivity() {
    override fun getLayoutRes() = R.layout.activity_chat

    override fun onSupportNavigateUp() = Navigation.findNavController(this, R.id.fragment_nav_host).navigateUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val graph = fragment_nav_host.findNavController().navInflater.inflate(R.navigation.nav_chat)
        val bundle = Bundle()
        bundle.putString(getString(R.string.arg_user_id), intent.getStringExtra(getString(R.string.arg_user_id)))
        findNavController(R.id.fragment_nav_host).setGraph(graph, bundle)
    }
}