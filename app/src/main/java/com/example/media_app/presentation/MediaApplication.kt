package com.example.media_app.presentation

import android.app.Application
import com.example.media_app.di.*
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MediaApplication : Application() {

    companion object {
        lateinit var sInstance: MediaApplication
            private set

        val getAppInstance: MediaApplication
            get() = sInstance
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        Stetho.initializeWithDefaults(this@MediaApplication)
        Timber.plant(Timber.DebugTree())
        setKoin()
    }

    private fun setKoin() = startKoin {
        androidContext(this@MediaApplication)
        modules(listOf(
                viewModelModule,
                repositoryModule,
                networkModule,
                serviceModule,

                databaseModule,
                daoModule
        ))
    }
}