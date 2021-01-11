package com.kotlin.basemvvm.net

data class BaseResp<out T>(val errno:Int,val errmsg:Int,val data:T)
