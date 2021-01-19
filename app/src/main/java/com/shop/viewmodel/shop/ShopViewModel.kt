package com.shop.viewmodel.shop

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shop.base.BaseViewModel
import com.shop.model.CarData
import com.shop.net.Injection
import kotlinx.coroutines.launch

class ShopViewModel:BaseViewModel(Injection.repository) {

    var carData:MutableLiveData<CarData> = MutableLiveData()

    /**
     * 获取购物车数据
     */
    fun getCar(){
        viewModelScope.launch {
            var result = repository.getCar()
            if(result.errno == 0){
                carData.postValue(result.data)
            }
        }
    }

    /**
     * 默认状态下的商品数据选中状态
     */
    fun updateCarStateNormal(boolean: Boolean){
        var list = carData.value!!.cartList
        for(i in 0..list.size){
            list.get(i).select_normal = boolean
        }
    }

    /**
     * 编辑状态下的商品数据选中状态
     */
    fun updateCarStateEidtor(boolean: Boolean){
        var list = carData.value!!.cartList
        for(i in 0..list.size){
            list.get(i).select_eidt = boolean
        }
    }

    /**
     * 计算当前购物车的总价和总数量
     */
    fun getCarTotalNormal():Array<Int>{
        var arr = arrayOf<Int>()
        var num=0
        var price = 0
        var list = carData.value!!.cartList
        for(i in 0..list.size){
            if(list.get(i).select_normal){
                num += list.get(i).number
                price += list.get(i).number*list.get(i).retail_price
            }
        }
        arr[0] = num
        arr[1] = price
        return arr
    }

    /**
     * 编辑状态下的计算
     */
    fun getCarTotalEidt():Array<Int>{
        var arr = arrayOf<Int>()
        var num=0
        var price = 0
        var list = carData.value!!.cartList
        for(i in 0..list.size){
            if(list.get(i).select_normal){
                num += list.get(i).number
                price += list.get(i).number*list.get(i).retail_price
            }
        }
        arr[0] = num
        arr[1] = price
        return arr
    }

}