package com.shop.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shop.R
import com.shop.databinding.ActivityBindingHomeBinding
import com.shop.viewmodel.BindHomeViewModel

class BindingHomeActivity : AppCompatActivity() {

    var mBinding:ActivityBindingHomeBinding? = null
    var mAdapter:BindHomeAdapter? = null
    var viewModel:BindHomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_binding_home)
        viewModel = ViewModelProvider(this).get(BindHomeViewModel::class.java)
        initView()
        viewModel!!.homeData()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this)
        mBinding!!.recyBrend.layoutManager = layoutManager
        mAdapter = BindHomeAdapter(this,viewModel!!.brand.value!!)
        mBinding!!.recyBrend.adapter = mAdapter

    }

}