package com.shop.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.model.Brand
import com.shop.model.GoodListData


class GoodListAdapter(
        context: Context,
        list:List<GoodListData.Goods>,
        layouts: SparseArray<Int>,
        click: IItemClick<GoodListData.Goods>
): BaseAdapter<GoodListData.Goods>(context,list,layouts,click){
    override fun layoutId(position: Int): Int {
        return R.layout.layout_goodlist_item
    }

    override fun bindData(binding: ViewDataBinding, data: GoodListData.Goods, layId: Int) {
    }
}