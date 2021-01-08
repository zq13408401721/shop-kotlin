package com.shop.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.shop.R
import com.shop.model.Banner
import com.shop.model.HomeData
import kotlinx.android.synthetic.main.activity_home2.*
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        loadHomeData()
    }

    //显示banner
    private fun showBanner(banners:List<Banner>){
        banner_home!!.setImages(banners)
        banner_home!!.setImageLoader(MyBannerAdapter())
        banner_home!!.start()
    }

    private fun loadHomeData() {
        var thread_name = Thread.currentThread().name
        MainScope().launch {
            var thread_name1 = Thread.currentThread().name
            var result = homeData()
            Log.i("TAG",result.errmsg);
            showBanner(result.data.banner)
        }
        Log.d("TAG","loadHomeData")
    }

    suspend fun homeData():HomeData{
        var url = "https://cdplay.cn/api/index"
        return get(url)
    }

    suspend fun get(netUrl:String) = withContext(Dispatchers.IO){
        var url = URL(netUrl)
        (url.openConnection() as? HttpsURLConnection).run {
            var sb = StringBuffer()
            var streamReader = InputStreamReader(this!!.inputStream,"utf-8")
            var reader = BufferedReader(streamReader)
            reader.use {
                var temp = reader.readLine()
                if(temp != null) sb.append(temp)
            }
            streamReader.close()
            reader.close()
            inputStream.close()
            val homeData = Gson().fromJson<HomeData>(sb.toString(),HomeData::class.java)
            return@run homeData
        }
    }

}