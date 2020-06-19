package com.example.media_app.di

import com.example.media_app.chat.chatting.ChatViewModel
import com.example.media_app.chat.post.PostViewModel
import com.example.media_app.chat.userlist.UserListViewModel
import com.example.media_app.presentation.createaccount.CreateAccountViewModel
import com.example.media_app.presentation.episode.EpisodeViewModel
import com.example.media_app.presentation.favorite.FavoriteViewModel
import com.example.media_app.presentation.home.HomeViewModel
import com.example.media_app.presentation.login.LoginViewModel
import com.example.media_app.presentation.main.MainViewModel
import com.example.media_app.presentation.news.NewsViewModel
import com.example.media_app.presentation.search.SearchViewModel
import com.example.media_app.presentation.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { LoginViewModel() }
    viewModel { CreateAccountViewModel() }
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { NewsViewModel() }
    viewModel { SearchViewModel() }
    viewModel { FavoriteViewModel() }
    viewModel { EpisodeViewModel() }
    viewModel { PostViewModel() }
    viewModel { UserListViewModel() }
    viewModel { ChatViewModel() }
}