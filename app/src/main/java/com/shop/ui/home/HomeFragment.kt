package com.shop.ui.home

import androidx.fragment.app.Fragment
import com.shop.R

class HomeFragment:Fragment(R.layout.fragment_home) {

    companion object{
        val instance:HomeFragment by lazy { HomeFragment() }
    }
}