package com.shweta.mvvmkoindemo.model

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsersAsync():Deferred<Response<Users>>
}