package com.shop.test

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shop.R
import com.shop.utils.DataBaseUtils

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        initView()
    }

    private fun initView() {
        println(DataBaseUtils.db)
        println(DataBaseUtils.db)
    }
}