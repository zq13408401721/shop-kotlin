package com.shop.test

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.model.VideoBean
import com.shop.model.X

class VideoAdapter(
        context:Context,
        list:List<X>,
        layouts:SparseArray<Int>,
        click: IItemClick<X>
):BaseAdapter<X>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
        return R.layout.layout_video_item
    }

    override fun bindData(binding: ViewDataBinding, data: X, layId: Int) {

    }
}