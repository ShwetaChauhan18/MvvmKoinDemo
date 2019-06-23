package com.shweta.mvvmkoindemo.base

import androidx.lifecycle.ViewModel
import com.shweta.mvvmkoindemo.di.WITH_OUT_HEADER
import com.shweta.mvvmkoindemo.model.ApiService
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.qualifier.named
import retrofit2.HttpException
import retrofit2.Response
import java.net.UnknownHostException
import kotlin.coroutines.CoroutineContext

open class BaseViewModel :ViewModel(), KoinComponent, CoroutineScope {

    protected val apiServiceWithoutHeader: ApiService by inject(named(WITH_OUT_HEADER))

    override val coroutineContext: CoroutineContext get() = Dispatchers.IO

    @SuppressWarnings("TooGenericExceptionCaught")
    fun <T : Any> call(deferred: Deferred<Response<T>>, apiCallbackListener: ApiCallbackListener<T>) {
        launch {
            try {
                val response = deferred.await()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        apiCallbackListener.onSuccess(response.body())
                    } else {

                    }
                }
            }
            catch (exception: HttpException) {
                withContext(Dispatchers.Main) {
                    apiCallbackListener.onError(exception)
                }
            } /*catch (exception: JsonParseException) {
                withContext(Dispatchers.Main) {
                    apiCallbackListener.onError(exception)
                }
            }*/ catch (exception: UnknownHostException) {
                withContext(Dispatchers.Main) {
                    apiCallbackListener.onError(Throwable("No Internet Connection available. Please try again after sometime."))
                }
            }
        }
    }

    interface ApiCallbackListener<T> {
        /**
         * This fun is used to success response of apis
         */
        fun onSuccess(data: T?)

        /**
         * This fun is used to error response of apis
         */
        fun onError(throwable: Throwable)
    }

    class Resource<out T>(val status: Status, val responseData: T?, val throwable: Throwable?) {
        companion object {
            /**
             * return success
             */
            fun <T> success(data: T?): Resource<T> {
                return Resource(Status.SUCCESS, data, null)
            }

            /**
             * return error
             */
            fun <T> error(throwable: Throwable?): Resource<T> {
                return Resource(Status.ERROR, null, throwable)
            }

            /*fun <T> loading(): Resource<T> {
                return Resource(Status.LOADING, null, null)
            }*/
        }
    }

    enum class Status {
        SUCCESS,
        ERROR
    }
}