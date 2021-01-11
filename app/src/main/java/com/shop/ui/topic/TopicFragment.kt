package com.shop.ui.topic

import androidx.fragment.app.Fragment
import com.shop.R
import com.shop.ui.sort.SortFragment

class TopicFragment:Fragment(R.layout.fragment_topic) {
    companion object{
        val instance by lazy { TopicFragment() }
    }
}