package com.shweta.mvvmkoindemo.viewmodel

import androidx.lifecycle.MutableLiveData
import com.shweta.mvvmkoindemo.base.BaseViewModel
import com.shweta.mvvmkoindemo.model.Users

class MainActivityViewModel : BaseViewModel() {

    val allUserssListLiveData = MutableLiveData<Resource<Users>>()

    fun callGithubApi() {
        call(apiServiceWithoutHeader.getUsersAsync(), object : ApiCallbackListener<Users> {
            override fun onSuccess(data: Users?) {
                data?.let {
                    allUserssListLiveData.value = Resource.success(it)
                }
            }

            override fun onError(throwable: Throwable) {
                allUserssListLiveData.value = Resource.error(throwable)
            }
        })
    }
}