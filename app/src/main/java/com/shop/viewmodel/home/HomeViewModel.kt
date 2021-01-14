package com.shop.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shop.base.BaseViewModel
import com.shop.model.Home
import com.shop.model.HomeData
import com.shop.net.Injection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel:BaseViewModel(Injection.repository) {

    /**
     * 首页的数据对象
     */
    var home:MutableLiveData<HomeData> = MutableLiveData()

    /**
     * V层调用
     */
    fun getHome(){
        viewModelScope.launch {
            var result = loadHomeData()
            home.postValue(result.data)
        }
    }

    /**
     * 加载首页数据
     */
    suspend fun loadHomeData() = withContext(Dispatchers.IO){
        repository.getHome()
    }

}