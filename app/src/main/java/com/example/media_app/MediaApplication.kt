package com.example.media_app

import android.app.Application
import com.facebook.stetho.Stetho
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
    }
}