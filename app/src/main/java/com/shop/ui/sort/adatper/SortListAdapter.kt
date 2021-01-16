package com.shop.ui.sort.adatper

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.shop.BR
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.model.SubCategory

class SortListAdapter(
    context: Context,
    list:List<SubCategory>,
    layouts:SparseArray<Int>,
    click: IItemClick<SubCategory>
): BaseAdapter<SubCategory>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
        return R.layout.layout_sortlist_item
    }

    override fun bindData(binding: ViewDataBinding, data: SubCategory, layId: Int) {
        //实现当前item的点击事件的赋值操作
        binding.setVariable(BR.sortClick,itemClick)
    }
}