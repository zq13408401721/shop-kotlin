package com.shop.ui.home

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.shop.BR
import com.shop.R
import com.shop.app.Constants
import com.shop.base.BaseActivity
import com.shop.base.IItemClick
import com.shop.databinding.ActivityHotgoodBinding
import com.shop.model.GoodListData
import com.shop.ui.home.adapter.GoodListAdapter
import com.shop.viewmodel.home.GoodListViewModel

class GoodListDetailActivity(
        var lid: Int = R.layout.activity_hotgood
):BaseActivity<GoodListViewModel, ActivityHotgoodBinding>(lid, GoodListViewModel::class.java){

    var list:MutableList<GoodListData.Goods> = mutableListOf()
    lateinit var goodlistAdapter:GoodListAdapter

    //是否是新品
    var isNew = 1
    var page = 1
    var size = 100
    var order: String? = null
    var sort: String? = null
    var categoryId = 0


    override fun initView() {
        mDataBinding.recyGoodList.layoutManager = GridLayoutManager(this, 2)
        var goodListArr = SparseArray<Int>()
        goodListArr.put(R.layout.layout_goodlist_item, BR.good);
        goodlistAdapter = GoodListAdapter(this, list, goodListArr, itemClick())
        mDataBinding.recyGoodList.adapter = goodlistAdapter

        order = Constants.ASC
        sort = Constants.DEFAULT
        categoryId = 0
        mDataBinding.layoutPrice.setTag(0)
        mDataBinding.txtAll.setTextColor(Color.parseColor("#ff0000"))
        mDataBinding.setVariable(R.layout.activity_hotgood,BR.goodList)
    }

    override fun initVM() {
        mViewModel.goodListData.observe(this, Observer {
            updateGoodList(it.goodsList)
        })
    }



    override fun initData() {
        var map = HashMap<String, String>()
        mViewModel.getGoodList(map)
    }

    override fun initVariable() {
    }

    fun updateGoodList(list: List<GoodListData.Goods>){
        this.list.clear()
        this.list.addAll(list)
        goodlistAdapter.notifyDataSetChanged()
    }


    /**
     * 组装当前的接口参数
     * @return
     */
    private fun getParam(): HashMap<String, String>? {
        val map = HashMap<String, String>()
        map["isNew"] = isNew.toString()
        map["page"] = page.toString()
        map["size"] = size.toString()
        map["order"] = order!!
        map["sort"] = sort!!
        map["category"] = categoryId.toString()
        return map
    }

    /**
     * 按价格升序排序
     */
    @SuppressLint("ResourceType")
    private fun priceStateUp() {
        mDataBinding.imgArrowUp.setImageResource(R.mipmap.ic_arrow_up_select)
        mDataBinding.imgArrowDown.setImageResource(R.mipmap.ic_arrow_down_normal)
        mDataBinding.txtPrice.setTextColor(Color.parseColor(getString(R.color.red)))
    }

    /**
     * 价格的降序排列
     */
    @SuppressLint("ResourceType")
    private fun priceStateDown() {
        mDataBinding.imgArrowUp.setImageResource(R.mipmap.ic_arrow_up_normal)
        mDataBinding.imgArrowDown.setImageResource(R.mipmap.ic_arrow_down_select)
        mDataBinding.txtPrice.setTextColor(Color.parseColor(getString(R.color.red)))
    }

    /**
     * 重置条件选择的所有状态
     */
    @SuppressLint("ResourceType")
    private fun resetPriceState() {
        mDataBinding.imgArrowUp.setImageResource(R.mipmap.ic_arrow_up_normal)
        mDataBinding.imgArrowDown.setImageResource(R.mipmap.ic_arrow_down_normal)
        mDataBinding.txtPrice.setTextColor(Color.parseColor(getString(R.color.black)))
        mDataBinding.txtAll.setTextColor(Color.parseColor(getString(R.color.black)))
        mDataBinding.txtSort.setTextColor(Color.parseColor(getString(R.color.black)))
        mDataBinding.layoutPrice.setTag(0)
    }

    inner class itemClick:IItemClick<GoodListData.Goods>{
        override fun itemClick(data: GoodListData.Goods) {

        }
    }

    /**
     * 界面的点击事件
     */

    inner class ClickEvt{
        fun clickPrice(){
            val tag = mDataBinding.layoutPrice.getTag() as Int
            if (tag == 0) {
                resetPriceState()
                priceStateUp()
                mDataBinding.layoutPrice.setTag(1)
                order = Constants.ASC
            } else if (tag == 1) {
                resetPriceState()
                priceStateDown()
                mDataBinding.layoutPrice.setTag(0)
                order = Constants.DESC
            }
            sort = Constants.PRICE
            getParam()?.let { mViewModel.getGoodList(it) }
        }

        fun clickAll(){
            resetPriceState()
            mDataBinding.txtAll.setTextColor(Color.parseColor("#ff0000"))
            sort = Constants.DEFAULT
            categoryId = 0
            getParam()?.let { mViewModel.getGoodList(it) }
        }

        fun clickSort(){
            resetPriceState()
            mDataBinding.txtSort.setTextColor(Color.parseColor("#ff0000"))
            sort = Constants.CATEGORY
            getParam()?.let { mViewModel.getGoodList(it) }
        }
    }
}