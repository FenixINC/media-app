package com.example.media_app.presentation.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.media_app.BR
import com.example.media_app.R
import com.example.media_app.data.entity.Article
import com.example.media_app.presentation.top_headline.TopHeadlineListener

class NewsAdapter(listener: TopHeadlineListener) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val clickListener: TopHeadlineListener = listener
    private val newsList: ArrayList<Article> = arrayListOf()

    fun setList(list: List<Article>) {
        newsList.clear()
        newsList.addAll(list)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Article = newsList[position]

    fun getList(): List<Article> = newsList

    override fun getItemCount(): Int = newsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holder: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.item_article, parent, false)
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any, listener: TopHeadlineListener) {
            binding.setVariable(BR.model, data)
            binding.setVariable(BR.clickListener, listener)
        }
    }
}