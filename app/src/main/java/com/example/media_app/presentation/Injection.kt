package com.example.media_app.presentation

import com.example.media_app.presentation.home.HomeViewModel
import com.example.media_app.presentation.login.LoginViewModel
import com.example.media_app.presentation.main.MainViewModel
import com.example.media_app.presentation.news.NewsViewModel
import com.example.media_app.presentation.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { LoginViewModel() }
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { NewsViewModel() }
}

val bindingModule = module {
    //    single { FragmentTopHeadlineBinding.inflate(get()) }
//    viewModel { FragmentTopHeadlineBinding.inflate(get()) }
}

val repositoryModule = module {
}

//val awsModule = module {
//    single { AWSMobileClient.getInstance() }
//}