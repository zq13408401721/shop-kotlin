package com.shop.test

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HotItemDecoration(
        var w:Int,
        var h:Int
): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if(parent.getChildLayoutPosition(view) % 2 == 0){
           outRect.set(w,h,w,0)
        }else{
            outRect.set(0,h,w,0)
        }
    }

}