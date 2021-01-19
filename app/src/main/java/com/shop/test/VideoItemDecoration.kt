package com.shop.test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.shop.R
import com.shop.utils.DpUtils
import kotlinx.android.synthetic.main.layout_video_item.view.*

class VideoItemDecoration(
        var context:Context
): RecyclerView.ItemDecoration() {

    private lateinit var paint:Paint
    var height = DpUtils.dp2px(150)

    init {
        paint = Paint()
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = Color.RED
        paint.strokeWidth = 6f
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        var imgHeader = parent.findViewById<ImageView>(R.id.img_header)
        var left=imgHeader.left+imgHeader.width/2
        var top = imgHeader.top+imgHeader.height
        var bottom = 0
        var count = parent.childCount
        for (i in 0..count){
            var view = parent.getChildAt(i)
            if(view == null) return
            bottom = view.bottom
            c.drawLine(left.toFloat(), top.toFloat(), left.toFloat(), bottom.toFloat(),paint)
        }


    }
}