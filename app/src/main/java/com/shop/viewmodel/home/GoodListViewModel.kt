package com.shop.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shop.base.BaseViewModel
import com.shop.model.GoodListData
import com.shop.net.Injection
import kotlinx.coroutines.launch

class GoodListViewModel: BaseViewModel(Injection.repository) {
    var goodListData:MutableLiveData<GoodListData> = MutableLiveData()   //商品列表的数据

    /**
     * 获取商品数据列表
     */
    fun getGoodList(map:HashMap<String,String>){
        viewModelScope.launch {
            var result = repository.getGoodList(map)
            goodListData.postValue(result.data)
        }
    }


}