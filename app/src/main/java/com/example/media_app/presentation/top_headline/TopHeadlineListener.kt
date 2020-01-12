package com.example.media_app.presentation.top_headline

import com.example.media_app.data.entity.Article

interface TopHeadlineListener {
    fun onItemClick(article: Article)
}