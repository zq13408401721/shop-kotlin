package com.shop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.shop.base.BaseViewModel
import com.shop.model.Banner
import com.shop.model.Brand
import com.shop.model.HomeData
import com.shop.model.HotGoods
import com.shop.net.Injection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class HomeViewModel:BaseViewModel(Injection.repository) {

    // 定义轮播图数据对象
    var banner:MutableLiveData<List<Banner>> = MutableLiveData()

    // 定义一个品牌制造商直供
    var brend:MutableLiveData<List<Brand>> = MutableLiveData()

    // 定义一个热门数据
    var hotGoods:MutableLiveData<List<HotGoods>> = MutableLiveData()

    //网络请求的状态值  -1 网络请求错误
    var loadStatue:MutableLiveData<Int> = MutableLiveData()

    var homeData:MutableLiveData<HomeData> = MutableLiveData()

    /**
     * 加载首页数据
     */
    fun loadHomeData(){
        GlobalScope.launch {
            loadData()
        }
    }

    /**
     * 定义给V层调用的方法
     */
    private suspend fun loadData(){
        var result = repository.getHome()
        if(result != null){
            homeData.postValue(result.data)
        }else{
            loadStatue.postValue(-1)
        }
    }

    /**
     * 网络请求
     */
    suspend fun get(str:String) = withContext(Dispatchers.IO){
        var result = URL(str).readText(charset("utf-8"))
        return@withContext Gson().fromJson<HomeData>(result,HomeData::class.java)
    }


}