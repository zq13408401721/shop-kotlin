package com.kotlin.basemvvm.net

import java.util.concurrent.TimeUnit

class RetrofitFactory {

    /**
     * 伴生对象 单例
     */
    companion object{
        val instance:RetrofitFactory by lazy { RetrofitFactory() }
    }



}