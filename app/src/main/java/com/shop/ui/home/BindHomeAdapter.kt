package com.shop.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shop.BR
import com.shop.R
import com.shop.model.Brand

class BindHomeAdapter(var context:Context,val list:List<Brand>): RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),viewType,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        var binding:ViewDataBinding = holder.dataBinding
        binding.setVariable(BR.vmBrand,list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.layout_brand_item
    }
}