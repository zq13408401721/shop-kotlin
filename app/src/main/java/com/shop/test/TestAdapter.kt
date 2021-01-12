package com.shop.test

import android.content.Context
import android.util.SparseArray
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.model.Home

class TestAdapter(context: Context, list:List<Home.HotGoods>,layouts:SparseArray<Int>):BaseAdapter<Home.HotGoods>(context,list,layouts) {
    
    override fun layoutId(position: Int): Int {
        return R.layout.layout_hotgood
    }

    override fun bindData(binding: ViewDataBinding, data: Home.HotGoods) {
        Glide.with(context).load(data.list_pic_url).into(binding.root.findViewById(R.id.img))
    }

}