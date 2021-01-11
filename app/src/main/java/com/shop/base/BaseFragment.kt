package com.shop.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<VM:BaseViewModel,DB:ViewDataBinding>(var layoutId:Int,var vmClass:Class<VM>):Fragment() {

    protected lateinit var mViewModel:VM
    protected lateinit var mDataBinding:DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(layoutId,container)
        mDataBinding = DataBindingUtil.bind<DB>(view)!!
        mViewModel = ViewModelProvider(this).get(vmClass)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initVM()
        initData()
        initVariable()
    }

    //val instance by lazy { BaseFragment<VM,DB>(layoutId,vmClass) }

    protected abstract fun initView()
    protected abstract fun initVM()
    protected abstract fun initData()
    protected abstract fun initVariable()

}