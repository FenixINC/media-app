package com.example.media_app.di

import com.example.media_app.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single { NewsRepository() }
    single { CharacterRepository() }
    single { EpisodeRepository() }
    single { LoginRepository() }
    single { PostRepository() }
    single { CreateAccountRepository() }
    single { UserListRepository() }
    single { ChatRepository() }
}