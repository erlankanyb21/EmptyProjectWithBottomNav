package com.example.myapp

import android.app.Application
import com.example.data.di.networkModule
import com.example.domain.di.domainModule
import com.example.myapp.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(module {
                includes(
                    mainModule,
                    domainModule,
                    networkModule
                )
            })
        }
    }
}