package com.shop.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.model.HotGoods

/**
 * 热门商品的adapter
 */
class HotGoodAdapter(
        context: Context,
        list:List<HotGoods>,
        layouts:SparseArray<Int>,
        click: IItemClick<HotGoods>
): BaseAdapter<HotGoods>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
        return R.layout.layout_hotgood_item
    }

    override fun bindData(binding: ViewDataBinding, data: HotGoods, layId: Int) {
    }
}