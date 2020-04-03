package com.example.media_app.presentation.news

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.media_app.R
import com.example.media_app.data.entity.Article
import com.example.media_app.data.entity.TopHeadline
import com.example.media_app.presentation.base.BaseFragment
import com.example.media_app.utils.ViewModelData
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.android.ext.android.inject

class NewsFragment : BaseFragment<NewsViewModel>() {

    private lateinit var newsAdapter: NewsAdapter

    override val viewModel by inject<NewsViewModel>()

    override fun getLayoutRes() = R.layout.fragment_news

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        val s = ItemTouchHelper.SimpleCallback
        setupAdapter()
        loadNews()
    }

    private fun setupAdapter() {
        newsAdapter = NewsAdapter { openNewsDetails(it) }
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = newsAdapter
    }

    private fun loadNews() {
        viewModel.loadNews()
        viewModel.newsData.observe(viewLifecycleOwner, Observer { setNewsList(it) })
    }

    private fun setNewsList(newsData: ViewModelData<TopHeadline, Exception, Boolean>) {
        if (newsData.data != null) {
            newsAdapter.newsList = newsData.data.articles.toMutableList()
        } else {
            newsData.error
        }
    }

    private fun openNewsDetails(article: Article) {
        Toast.makeText(activity, article.title, Toast.LENGTH_SHORT).show()
    }
}