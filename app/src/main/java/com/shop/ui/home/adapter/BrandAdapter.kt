package com.shop.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.shop.BR
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.model.Brand

class BrandAdapter(
        context: Context,
        list:List<Brand>,
        layouts:SparseArray<Int>,
        click: IItemClick<Brand>
): BaseAdapter<Brand>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
        return R.layout.layout_brand_item
    }

    override fun bindData(binding: ViewDataBinding, data: Brand, layId: Int) {

    }
}