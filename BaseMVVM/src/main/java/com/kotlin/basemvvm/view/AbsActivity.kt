package com.kotlin.basemvvm.view

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.kotlin.basemvvm.ext.bindView
import com.kotlin.basemvvm.mvvm.IBaseView

/**
 *  activity对应的基类
 */
abstract class AbsActivity<VM:ViewModel>(val layoutId:Int):AppCompatActivity(layoutId),IBaseView {

    protected var TAG = this.javaClass.simpleName

    protected lateinit var mActivity:Activity
    protected lateinit var mContext: Context
    protected var loadDialog:Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        mContext = this
        //设置输入键盘在软键盘上面
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        //设置竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        //设置状态栏透明

    }

    override fun showLoading() {
    }

    override fun dissLoading() {
    }
}