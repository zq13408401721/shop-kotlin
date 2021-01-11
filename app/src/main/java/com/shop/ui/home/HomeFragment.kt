package com.shop.ui.home

import androidx.fragment.app.Fragment
import com.shop.R
import com.shop.base.BaseFragment
import com.shop.databinding.FragmentHomeBinding
import com.shop.viewmodel.home.HomeViewModel

class HomeFragment(val lid:Int):BaseFragment<HomeViewModel,FragmentHomeBinding>(lid,HomeViewModel::class.java) {

    /**
     * 提供Homefragment实例
     */
    companion object{
        val instance:HomeFragment by lazy { HomeFragment(R.layout.fragment_home) }
    }

    override fun initView() {
    }

    override fun initVM() {
    }

    override fun initData() {
    }

    override fun initVariable() {
    }
}