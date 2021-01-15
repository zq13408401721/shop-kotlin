package com.shop.api

import com.shop.model.*
import com.shop.net.BaseResp
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.util.HashMap

interface ServiceApi {


    @POST("auth/refreshToken")  //刷新token
    suspend fun refreshToken():BaseResp<String>

    @GET("index")
    suspend fun getHome():BaseResp<HomeData>   // BaseResp抽取的一个bean类的外层结构 homeData当前接口返回的具体

    //专题
    @GET("topic/list")
    suspend fun getTopic(@Query("page") page:Int,@Query("size") size:Int):BaseResp<TopicData>

    //商品列表详情
    @GET("goods/list")
    suspend fun getGoodList(@QueryMap map:HashMap<String,String>):BaseResp<GoodListData>

    //分类数据
    @GET("catalog/index")
    suspend fun getSortData(@Query("id") id:String):BaseResp<SortData>

    //分类对应的详情数据
    @GET("catalog/current")
    suspend fun getCatalogData(@Query("id") id:String):BaseResp<SortListData>


}