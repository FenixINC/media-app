package com.example.media_app

import com.example.media_app.di.networkModule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class ModuleTest : KoinTest {

    @Test
    fun testKoinModules () {
        startKoin {
            modules(listOf(networkModule))
        }.checkModules()

        stopKoin()
    }
}