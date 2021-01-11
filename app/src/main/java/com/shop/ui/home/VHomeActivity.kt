package com.shop.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shop.BR
import com.shop.BaseA
import com.shop.R
import com.shop.base.BaseActivity
import com.shop.databinding.ActivityVHomeBinding
import com.shop.viewmodel.HomeViewModel

class VHomeActivity:BaseActivity<HomeViewModel,ActivityVHomeBinding>(R.layout.activity_v_home,HomeViewModel::class.java) {
    override fun initView() {

    }

    override fun initVM() {
        mViewModel.homeData.observe(this, Observer {
            mDataBinding.setVariable(BR.vmHome,it)
            mDataBinding.txtTitle.setText("xxx")
        })
    }

    override fun initData() {
        mViewModel.loadHomeData()
    }

    override fun initVariable() {
        mDataBinding.setVariable(BR.vmHome,mViewModel.homeData.value)
    }

}