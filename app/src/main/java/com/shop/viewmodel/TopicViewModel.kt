package com.shop.viewmodel

import androidx.lifecycle.viewModelScope
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import kotlinx.coroutines.launch

class TopicViewModel:BaseViewModel(Injection.repository){

    /**
     * 获取专题数据
     */
    fun getTopic(){
        viewModelScope.launch {
            var result = repository.getTopic()
            if(result.errno == 0){

            }else if(result.errno == 665){
                refreshToken()
            }
        }
    }

}