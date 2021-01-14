package com.shop.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.shop.BR
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.model.Brand
import com.shop.model.NewGoods

class NewGoodAdapter(
        context: Context,
        list:List<NewGoods>,
        layouts: SparseArray<Int>,
        click: IItemClick<NewGoods>
): BaseAdapter<NewGoods>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
        return R.layout.layout_newgood_item
    }

    override fun bindData(binding: ViewDataBinding, data: NewGoods, layId: Int) {

    }
}