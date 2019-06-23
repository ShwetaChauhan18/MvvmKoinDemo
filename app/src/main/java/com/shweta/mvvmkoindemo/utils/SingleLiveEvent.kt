package com.shweta.mvvmkoindemo.utils

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val mPending = AtomicBoolean(false)

    /**
     * This method is used to watch liveData
     * @param owner LifecycleOwner
     * @param observer Observer<T>
     */
    @MainThread
    fun watchData(owner: LifecycleOwner, observer: Observer<T>) {

        if (hasActiveObservers()) {
            //Timber.tag(TAG).w("Multiple observers registered but only one will be notified of changes.")
        }

        // Observe the internal MutableLiveData
        super.observe(owner, Observer { t ->
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(t: T?) {
        mPending.set(true)
        super.setValue(t)
    }

    override fun postValue(value: T) {
        super.postValue(value)
        call()
    }

    @MainThread
    private fun call() {
        value = null
    }

    companion object {
        private val TAG = SingleLiveEvent::class.java.simpleName
    }
}