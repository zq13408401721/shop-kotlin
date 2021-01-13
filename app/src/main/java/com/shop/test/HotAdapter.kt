package com.shop.test

import android.content.Context
import android.util.SparseArray
import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.TransitionOptions
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.shop.BR
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.ext.findView
import com.shop.model.HotBean

class HotAdapter(
        context:Context,
        list:List<HotBean.X>,
        layouts:SparseArray<Int>,
        var clicks:IItemClick<HotBean.X>
):BaseAdapter<HotBean.X>(context,list,layouts,clicks) {

    /**
     * 多布局判断当前使用有图，无图，多张图
     */
    override fun layoutId(position: Int): Int {
        var imgs = list.get(position).filePathList
        when(imgs.size){
            0 -> return R.layout.layout_hot_item_noimage
            1 -> return R.layout.layout_hot_one_image
            else -> return R.layout.layout_hot_three_image
        }
    }

    /**
     * 刷新列表条目
     */
    override fun bindData(binding: ViewDataBinding, data: HotBean.X,layId:Int) {
        when(layId){
            R.layout.layout_hot_one_image -> {
                binding.setVariable(BR.hotOne,clicks)
                //获取界面的组件
                //var img = binding.root.findView<ImageView>(R.id.img).value
                //Glide.with(context).load(data.filePathList.first().filePath).apply(RequestOptions().transform(CenterCrop(),RoundedCorners(20))).into(img)
            }
            R.layout.layout_hot_three_image -> {
                binding.setVariable(BR.hotThree,clicks)
                //var imgOne = binding.root.findView<ImageView>(R.id.img_one).value
                //var imgTwo = binding.root.findView<ImageView>(R.id.img_two).value
                //var imgThree = binding.root.findView<ImageView>(R.id.img_three).value
                //var round = RoundedCorners(20)
                //Glide.with(context).load(data.filePathList.first().filePath).apply(RequestOptions().transform(CenterCrop(),round)).into(imgOne)
                //Glide.with(context).load(data.filePathList[1].filePath).apply(RequestOptions().transform(CenterCrop(),round)).into(imgTwo)
                //Glide.with(context).load(data.filePathList.last().filePath).apply(RequestOptions().transform(CenterCrop(),round)).into(imgThree)
            }
        }
    }
}