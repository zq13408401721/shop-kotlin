package com.shop.ui.home

import androidx.lifecycle.Observer
import com.shop.R
import com.shop.base.BaseActivity
import com.shop.databinding.ActivityTopicBinding
import com.shop.viewmodel.TopicViewModel

class TopicActivity:BaseActivity<TopicViewModel,ActivityTopicBinding>(R.layout.activity_topic,TopicViewModel::class.java) {
    override fun initView() {

    }

    override fun initVM() {
        /**
         * token刷新的数据状态的监听
         */
        mViewModel.refreshToken.observe(this, Observer {
            when(it){
                1 -> {
                    //
                }
                2 -> {

                }
            }
        })
    }

    override fun initData() {
        mViewModel.getTopic()
    }

    override fun initVariable() {

    }
}