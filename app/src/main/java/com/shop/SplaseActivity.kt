package com.shop

import android.content.Intent
import androidx.lifecycle.Observer
import com.shop.base.BaseActivity
import com.shop.databinding.ActivitySplaseBinding
import com.shop.viewmodel.SplaseViewModel

class SplaseActivity:BaseActivity<SplaseViewModel,ActivitySplaseBinding>(R.layout.activity_splase,SplaseViewModel::class.java) {
    override fun initView() {

    }

    override fun initVM() {
        mViewModel.state.observe(this, Observer {
            if(it == 0){
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }

    override fun initData() {
        mViewModel.login()
    }

    override fun initVariable() {
    }
}