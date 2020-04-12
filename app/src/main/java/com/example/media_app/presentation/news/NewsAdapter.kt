package com.example.media_app.presentation.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.media_app.data.network.dto.tmp.Article
import com.example.media_app.databinding.ItemArticleBinding

class NewsAdapter(private val newsListener: (Article) -> Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var newsList = mutableListOf<Article>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = newsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holder = ItemArticleBinding.inflate(inflater, parent, false)
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position], newsListener)
    }

    class ViewHolder(private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: Article, listener: (Article) -> Unit) = with(binding) {
//            model = news
            layoutArticle.setOnClickListener { listener(news) }
        }
    }
}