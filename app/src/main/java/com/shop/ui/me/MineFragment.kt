package com.shop.ui.me

import androidx.fragment.app.Fragment
import com.shop.R
import com.shop.base.BaseFragment
import com.shop.databinding.FragmentMineBinding
import com.shop.viewmodel.mine.MineViewModel

class MineFragment:BaseFragment<MineViewModel,FragmentMineBinding>(R.layout.fragment_mine,MineViewModel::class.java) {
    companion object{
        val instance by lazy { MineFragment() }
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