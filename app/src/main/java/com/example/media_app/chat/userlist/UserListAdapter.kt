package com.example.media_app.chat.userlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.media_app.chat.model.UserModel
import com.example.media_app.databinding.ListItemUserBinding

class UserListAdapter(private val userListener: (UserModel) -> Unit) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    var userList = mutableListOf<UserModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = userList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holder = ListItemUserBinding.inflate(inflater, parent, false)
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(user = userList[position], listener = userListener)
    }

    class ViewHolder(private val binding: ListItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserModel, listener: (UserModel) -> Unit) = with(binding) {
            setUser(user)
            userLayout.setOnClickListener { listener(user) }
            userImage // TODO: make circle image
        }
    }
}