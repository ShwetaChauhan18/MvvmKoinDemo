package com.shweta.mvvmkoindemo.di

import com.shweta.mvvmkoindemo.MainActivity
import com.shweta.mvvmkoindemo.viewmodel.MainActivityViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {

    scope(named<MainActivity>()) {
        scoped { MainActivityViewModel() }
    }
}