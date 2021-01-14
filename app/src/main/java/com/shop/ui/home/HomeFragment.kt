package com.shop.ui.home

import android.content.Intent
import android.util.Log
import android.util.SparseArray
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.shop.BR
import com.shop.R
import com.shop.base.BaseFragment
import com.shop.base.IItemClick
import com.shop.databinding.FragmentHomeBinding
import com.shop.model.Brand
import com.shop.model.HotGoods
import com.shop.model.NewGoods
import com.shop.test.TestActivity
import com.shop.ui.home.adapter.BrandAdapter
import com.shop.ui.home.adapter.HotGoodAdapter
import com.shop.ui.home.adapter.NewGoodAdapter
import com.shop.viewmodel.home.HomeViewModel

class HomeFragment(val lid:Int):BaseFragment<HomeViewModel,FragmentHomeBinding>(lid,HomeViewModel::class.java) {

    /**
     * 提供Homefragment实例
     */
    companion object{
        val instance:HomeFragment by lazy { HomeFragment(R.layout.fragment_home) }
    }

    lateinit var brandAdapter:BrandAdapter
    var brandList:MutableList<Brand> = mutableListOf()

    lateinit var newGoodAdapter:NewGoodAdapter
    var newgoodList:MutableList<NewGoods> = mutableListOf()

    //热门商品
    lateinit var hotgoodAdapter:HotGoodAdapter
    var hotgoodList:MutableList<HotGoods> = mutableListOf()

    override fun initView() {
        initBrand()
        initNewGood()
        initHotGood()
        mDataBinding.setVariable(BR.homeClick,TitleClick())
    }

    override fun initVM() {
        mViewModel.home.observe(this, Observer {
            updateBrand(it.brandList)
            updateNewGood(it.newGoodsList)
            updateHotGood(it.hotGoodsList)
        })
    }

    //初始化品牌制造
    fun initBrand(){
        mDataBinding.recyBrand.layoutManager = GridLayoutManager(context,2)
        var brandArr = SparseArray<Int>()
        brandArr.put(R.layout.layout_brand_item, BR.vmBrand)
        var brandClick = BrandItemClick()
        brandAdapter = BrandAdapter(context!!,brandList,brandArr,brandClick)
        mDataBinding.recyBrand.adapter = brandAdapter
    }

    //初始化新品发布
    fun initNewGood(){
        mDataBinding.recyNewgood.layoutManager = GridLayoutManager(context,2)
        var newGoodArr = SparseArray<Int>()
        newGoodArr.put(R.layout.layout_newgood_item,BR.vmNewGood)
        var newGoodClick = NewGoodItemClick()
        newGoodAdapter = NewGoodAdapter(context!!,newgoodList,newGoodArr,newGoodClick)
        mDataBinding.recyNewgood.adapter = newGoodAdapter
    }

    //初始化热门商品
    fun initHotGood(){
        mDataBinding.recyHotgood.layoutManager = LinearLayoutManager(context)
        var hotGoodsArr = SparseArray<Int>()
        hotGoodsArr.put(R.layout.layout_hotgood_item,BR.vmHotGood)
        hotgoodAdapter = HotGoodAdapter(context!!,hotgoodList,hotGoodsArr,HotGoodsItemClick())
        mDataBinding.recyHotgood.adapter = hotgoodAdapter
    }

    //显示品牌制造商列表
    fun updateBrand(list:List<Brand>){
        brandList.clear()
        brandList.addAll(list)
        brandAdapter.notifyDataSetChanged()
    }

    //显示新品
    fun updateNewGood(list: List<NewGoods>){
        newgoodList.clear()
        newgoodList.addAll(list)
        newGoodAdapter.notifyDataSetChanged()
    }

    //显示热门商品
    fun updateHotGood(list: List<HotGoods>){
        hotgoodList.clear()
        hotgoodList.addAll(list)
        hotgoodAdapter.notifyDataSetChanged()
    }

    override fun initData() {
        mViewModel.getHome()

    }

    override fun initVariable() {
    }

    /**
     * 品牌条目点击
     */
    inner class BrandItemClick:IItemClick<Brand>{
        override fun itemClick(data: Brand) {
            //点击品牌条目
        }
    }

    /**
     * 新品发布
     */
    inner class NewGoodItemClick:IItemClick<NewGoods>{
        override fun itemClick(data: NewGoods) {

        }

    }

    //热门商品的条目点击
    inner class HotGoodsItemClick:IItemClick<HotGoods>{
        override fun itemClick(data: HotGoods) {
            TODO("Not yet implemented")
        }

    }

    inner class TitleClick{
        //品牌直供
        fun clickBrand(){
            Log.i("TAG","clickBrand")
        }
        //新品发布
        fun clickNewGood(){
            Log.i("TAG","clickNewGood")
            var intent = Intent(context,GoodListDetailActivity::class.java)
            startActivity(intent)
        }
        //人气推荐
        fun clickHotGood(){
            var intent = Intent(context,GoodListDetailActivity::class.java)
            startActivity(intent)
        }
        //专题
        fun clickTopic(){

        }
    }
}