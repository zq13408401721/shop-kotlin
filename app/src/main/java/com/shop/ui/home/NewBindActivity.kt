package com.shop.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.shop.R
import com.shop.databinding.ActivityNewBindBinding
import com.shop.viewmodel.NewBindViewModel

class NewBindActivity : AppCompatActivity() {

    var mBinding:ActivityNewBindBinding? = null
    var vm:NewBindViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_new_bind)
        initVM()
    }

    fun initVM(){
        vm = ViewModelProvider(this).get(NewBindViewModel::class.java)
        vm!!.homeData()
        mBinding!!.title.text = vm!!.title
    }
}