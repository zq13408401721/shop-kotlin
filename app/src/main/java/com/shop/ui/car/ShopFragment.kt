package com.shop.ui.car

import android.util.SparseArray
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shop.BR
import com.shop.R
import com.shop.base.BaseFragment
import com.shop.base.BaseViewModel
import com.shop.base.IItemClick
import com.shop.databinding.FragmentShopBinding
import com.shop.model.Cart
import com.shop.ui.car.adapter.CarAdapter
import com.shop.ui.sort.SortFragment
import com.shop.viewmodel.shop.ShopViewModel
import kotlinx.android.synthetic.main.fragment_shop.*

class ShopFragment(val lid:Int):BaseFragment<ShopViewModel,FragmentShopBinding>(lid,ShopViewModel::class.java) {


    lateinit var list:MutableList<Cart>
    lateinit var carAdapter:CarAdapter

    companion object{
        val instance by lazy { ShopFragment(R.layout.fragment_shop) }
    }

    override fun initView() {
        list = mutableListOf()
        var arr = SparseArray<Int>()
        arr.put(R.layout.layout_car_item,BR.catData)
        carAdapter = CarAdapter(context!!,list,arr,ClickItem())
        recy_car.layoutManager = LinearLayoutManager(context)
        recy_car.adapter = carAdapter
    }

    override fun initVM() {
        mViewModel.carData.observe(this, Observer {
            list.clear()
            list.addAll(it.cartList)
            carAdapter.notifyDataSetChanged()
        })
    }

    override fun initData() {
        mViewModel.getCar()
    }

    override fun initVariable() {
    }

    inner class ClickItem:IItemClick<Cart>{
        override fun itemClick(data: Cart) {
            TODO("Not yet implemented")
        }

    }

    /**
     * 当前界面的点击事件
     */
    inner class ClickEvt{

        /**
         * boolean true权限  false 非全选
         */
        fun clickAll(boolean: Boolean){
            if(boolean){
                mDataBinding.checkboxAll.isChecked = false
            }else{
                mDataBinding.checkboxAll.isChecked = true
            }
        }

        /**
         * boolean true编辑 false完成
         */
        fun clickEdit(value: String){
            if(value === "编辑"){
                mDataBinding.txtEdit.setText("完成")
                mDataBinding.txtSubmit.setText("删除所选")
            }else{
                mDataBinding.txtEdit.setText("编辑")
                mDataBinding.txtSubmit.setText("下单")
            }

        }

        /**
         * 是否是提交
         */
        fun clickSubit(value: String){
            if(value === "下单"){
                //下单
            }else{
                //删除对应的数据
            }
        }


    }
}