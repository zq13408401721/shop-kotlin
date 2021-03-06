package com.shop.test

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.SparseArray
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.gson.Gson
import com.shop.BR
import com.shop.R
import com.shop.base.IItemClick
import com.shop.model.Home
import com.shop.model.HomeData
import com.shop.model.HotBean
import com.shop.net.BaseResp
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class TestActivity : AppCompatActivity() {

    var handler:Handler = Handler()
    lateinit var adapter:TestAdapter
    lateinit var context:Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        context = this
        recy.layoutManager = LinearLayoutManager(this)
        initData()
    }

    private fun initData() {
        GlobalScope.launch {
            var home = loadData("http://cdwan.cn/api/index")
            handler.post(Runnable {
                //封装xml布局界面的id和界面中需要绑定的数据对应的id hashmap
                var array = SparseArray<Int>()
                array.put(R.layout.layout_hotgood,BR.vmHotGood)
                array.put(R.layout.layout_hotgood_noimage,BR.vmHotGoodNoImage)
                adapter = TestAdapter(context,home.hotGoodsList,array,ItemClick())
                recy.adapter = adapter
            })
        }

    }

    suspend fun loadData(str:String) = withContext(Dispatchers.IO){
        var url = URL(str).readText(charset("utf-8"))
        return@withContext Gson().fromJson<Home>(url, Home::class.java)
    }

    inner class ItemClick:IItemClick<Home.HotGoods>{

        override fun itemClick(data: Home.HotGoods) {
            Log.i("TAG","onclick")
        }
    }
}