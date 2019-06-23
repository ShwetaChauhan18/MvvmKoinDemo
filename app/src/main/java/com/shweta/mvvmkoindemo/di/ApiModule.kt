package com.shweta.mvvmkoindemo.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.shweta.mvvmkoindemo.BuildConfig
import com.shweta.mvvmkoindemo.model.ApiService
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val WITH_OUT_HEADER: String = "WITH_OUT_HEADER"
const val WITH_OUT_HEADER_CLIENT: String = "WITH_OUT_HEADER_CLIENT"
private const val HTTP_LOGGING_INTERCEPTOR: String = "HTTP_LOGGING_INTERCEPTOR"

val apiModule = module{

    /*single<Interceptor>(named(HTTP_LOGGING_INTERCEPTOR)) {
        HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            Timber.i(message)
        }).run {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }*/

    single(named(WITH_OUT_HEADER_CLIENT)) {
        OkHttpClient.Builder().apply {
            readTimeout(1, TimeUnit.MINUTES)
            connectTimeout(2, TimeUnit.MINUTES)
            writeTimeout(1, TimeUnit.MINUTES)
        }.build()
    }

    single(named(WITH_OUT_HEADER)) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get(named(WITH_OUT_HEADER)))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}