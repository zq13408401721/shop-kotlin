package com.shop.test

import android.content.Context
import android.text.TextUtils
import android.util.SparseArray
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.model.Home


/**
 * 适配器子类的实现
 */
class TestAdapter(
        context: Context,
        list:List<Home.HotGoods>,
        layouts:SparseArray<Int>,
        var clickEvts: SparseArray<Int> = SparseArray<Int>()
)
    :BaseAdapter<Home.HotGoods>(context,list,layouts,clickEvts) {

    override fun layoutId(position: Int): Int {
        var url =  list.get(position).list_pic_url
        if(TextUtils.isEmpty(url)){
            return R.layout.layout_hotgood_noimage
        }
        return R.layout.layout_hotgood
    }

    /**
     * 刷新条目的数据
     */
    override fun bindData(binding: ViewDataBinding, data: Home.HotGoods) {
        Glide.with(context).load(data.list_pic_url).into(binding.root.findViewById(R.id.img))
    }

}