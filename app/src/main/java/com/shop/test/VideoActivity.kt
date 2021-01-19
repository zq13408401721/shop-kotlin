package com.shop.test

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.SparseArray
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.shop.BR
import com.shop.R
import com.shop.base.IItemClick
import com.shop.model.*
import com.shop.net.BaseResp
import kotlinx.android.synthetic.main.activity_hot.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class VideoActivity : AppCompatActivity() {

    lateinit var videoAdapter:HVideoAdapter
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
            var videoBean = loadData("http://cdwan.cn:7000/tongpao/home/video.json")
            //封装xml布局界面的id和界面中需要绑定的数据对应的id hashmap
            var array = SparseArray<Int>()
            array.put(R.layout.layout_video_hitem,BR.videoItem)
            handler.post {
                videoAdapter = HVideoAdapter(context,videoBean.data.list,array,ItemClickImpl())
                //recyclerview.addItemDecoration(DividerItemDecoration(contexadt,DividerItemDecoration.HORIZONTAL))
                recyclerview.addItemDecoration(VideoItemDecoration(context))
                recyclerview.layoutManager = LinearLayoutManager(context)
                recyclerview.adapter = videoAdapter
            }

        }

    }

    suspend fun load(){
        GlobalScope.launch {

        }
    }


    suspend fun loadData(str:String) = withContext(Dispatchers.IO){
        var url = URL(str).readText(charset("utf-8"))
        return@withContext Gson().fromJson<VideoBean>(url, VideoBean::class.java)
    }

    suspend fun loadTopic(str:String) = withContext(Dispatchers.IO){
        var url = URL(str).readText(charset("utf-8"))
        return@withContext Gson().fromJson<TopicData>(url, TopicData::class.java)
    }

    inner class ItemClickImpl:IItemClick<X>{
        override fun itemClick(data: X) {
            Log.i("TAG",data.content)
        }

    }
}