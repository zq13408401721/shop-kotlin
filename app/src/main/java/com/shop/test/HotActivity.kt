package com.shop.test

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.SparseArray
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.shop.BR
import com.shop.R
import com.shop.base.IItemClick
import com.shop.model.Home
import com.shop.model.HotBean
import kotlinx.android.synthetic.main.activity_hot.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class HotActivity : AppCompatActivity() {

    lateinit var hotAdapter:HotAdapter
    lateinit var context:Context
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot)
        context = this
        initData()
    }

    private fun initData() {
        GlobalScope.launch {
            var hotBean = loadData("http://cdwan.cn:7000/tongpao/discover/hot.json")
            //封装xml布局界面的id和界面中需要绑定的数据对应的id hashmap
            var array = SparseArray<Int>()
            array.put(R.layout.layout_hot_item_noimage,BR.vmNoImage)
            array.put(R.layout.layout_hot_one_image, BR.vmOneImage)
            array.put(R.layout.layout_hot_three_image,BR.vmThreeImage)
            handler.post {
                hotAdapter = HotAdapter(context,hotBean.data.list,array,ItemClickImpl())
                recyclerview.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.HORIZONTAL))
                recyclerview.layoutManager = LinearLayoutManager(context)
                recyclerview.adapter = hotAdapter
            }

        }

    }

    suspend fun loadData(str:String) = withContext(Dispatchers.IO){
        var url = URL(str).readText(charset("utf-8"))
        return@withContext Gson().fromJson<HotBean>(url, HotBean::class.java)
    }

    inner class ItemClickImpl:IItemClick<HotBean.X>{
        override fun itemClick(data: HotBean.X) {
            Log.i("TAG",data.content)
        }

    }
}