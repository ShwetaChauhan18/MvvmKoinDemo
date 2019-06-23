package com.shweta.mvvmkoindemo.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single {
        androidContext().resources
    }

    single {
        //PreferenceUtils()
    }

    single {
        androidContext().getSharedPreferences(androidContext().packageName, Context.MODE_PRIVATE)
    }
}