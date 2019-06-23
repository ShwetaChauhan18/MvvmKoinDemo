package com.shweta.mvvmkoindemo

import android.app.Application
import com.shweta.mvvmkoindemo.di.apiModule
import com.shweta.mvvmkoindemo.di.appModule
import com.shweta.mvvmkoindemo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MvvmKoinApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MvvmKoinApp)
            modules(listOf(appModule, apiModule, viewModelModule))
        }
    }
}