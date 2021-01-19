package com.shop.ui.car.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.model.Cart

/**
 *购物车列表
 */
class CarAdapter(
        context: Context,
        list:List<Cart>,
        layouts:SparseArray<Int>,
        click: IItemClick<Cart>
): BaseAdapter<Cart>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
        return R.layout.layout_car_item
    }

    override fun bindData(binding: ViewDataBinding, data: Cart, layId: Int) {
       //绑定界面的数据对象

    }
}