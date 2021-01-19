package com.shop.utils

import com.shop.app.MyApp

class DpUtils {
    companion object{
        fun dp2px(num:Int):Int{
            var scale:Float = MyApp.instance!!.resources.displayMetrics.density
            return (num*scale+0.5f).toInt()
        }
    }
}