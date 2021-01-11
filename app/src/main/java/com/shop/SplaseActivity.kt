package com.shop

import android.content.Intent
import com.shop.base.BaseActivity
import com.shop.databinding.ActivitySplaseBinding
import com.shop.viewmodel.SplaseViewModel

class SplaseActivity:BaseActivity<SplaseViewModel,ActivitySplaseBinding>(R.layout.activity_splase,SplaseViewModel::class.java) {
    override fun initView() {
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun initVM() {
        TODO("Not yet implemented")
    }

    override fun initData() {
        TODO("Not yet implemented")
    }

    override fun initVariable() {
        TODO("Not yet implemented")
    }
}