package com.shop.ui.car

import androidx.fragment.app.Fragment
import com.shop.R
import com.shop.ui.sort.SortFragment

class ShopFragment:Fragment(R.layout.fragment_shop) {
    companion object{
        val instance by lazy { ShopFragment() }
    }
}