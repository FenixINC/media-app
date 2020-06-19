package com.example.media_app.chat.userlist

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.media_app.R
import com.example.media_app.chat.chatting.ChatActivity
import com.example.media_app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.android.ext.android.inject

class UserListFragment : BaseFragment<UserListViewModel>() {

    private lateinit var userListAdapter: UserListAdapter

    override val viewModel by inject<UserListViewModel>()

    override fun getLayoutRes() = R.layout.fragment_user_list

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setAdapter()
        loadUserData()
    }

    private fun loadUserData() {
        showLoading()
        viewModel.loadUserLIst()
        viewModel.userListLiveData.observe(viewLifecycleOwner, Observer {
            hideLoading()
            if (it.data != null) {
                userListAdapter.userList = it.data.toMutableList()
            }
            if (it.error != null) {
                // TODO: show error message
            }
        })
    }

    private fun setAdapter() {
        userListAdapter = UserListAdapter { openUserChat(it.id) }
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = userListAdapter
    }

    private fun openUserChat(userId: String?) {
        val intent = Intent(activity, ChatActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        intent.putExtra(getString(R.string.arg_user_id), userId)
        startActivity(intent)
    }
}