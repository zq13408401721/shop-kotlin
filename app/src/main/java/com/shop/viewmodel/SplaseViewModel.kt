package com.shop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shop.app.Constants
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.shop.utils.MyMmkv
import kotlinx.coroutines.launch

class SplaseViewModel:BaseViewModel(Injection.repository) {

    var state:MutableLiveData<Int> = MutableLiveData()

    fun login(){
        var username = "z1234"
        var password = "123456"

        /**
         * login调用的协程
         */
        viewModelScope.launch {
            var result = repository.login(username,password)
            MyMmkv.setValue(Constants.token,result.data.token)
            state.postValue(result.errno)
        }

    }



}