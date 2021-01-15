package com.shop.viewmodel.sort

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shop.base.BaseViewModel
import com.shop.model.SortData
import com.shop.model.SortListData
import com.shop.net.Injection
import kotlinx.coroutines.launch

class SortViewModel:BaseViewModel(Injection.repository) {

    var sortData:MutableLiveData<SortData> = MutableLiveData()  //竖导航数据

    var sortDataList:MutableLiveData<SortListData> = MutableLiveData()

    /**
     * 获取竖导航列表
     */
    fun getSortData(id:String){
        viewModelScope.launch {
            var result = repository.getSortData(id)
            if(result.errno == 0){
                sortData.postValue(result.data)
            }
        }
    }

    /**
     * 竖导航列表数据
     */
    fun getSortListData(id:String){
        viewModelScope.launch {
            var result = repository.getCatalogData(id)
            if(result.errno == 0){
                sortDataList.postValue(result.data)
            }
        }
    }

}