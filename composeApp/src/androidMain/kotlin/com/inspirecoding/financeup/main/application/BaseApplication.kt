package com.inspirecoding.financeup.main.application

import android.app.Application
import com.inspirecoding.financeup.di.initializeKoin
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin {
            androidContext(this@BaseApplication)
        }
    }
}