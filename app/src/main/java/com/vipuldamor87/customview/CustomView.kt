package com.vipuldamor87.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View


class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val rect = Rect()
        rect.left = 10
        rect.top = 10
        rect.right = rect.left + 100
        rect.bottom = rect.top + 100
        val paint = Paint()
        paint.color = Color.RED
        //canvas.drawRect(rect,paint)
        canvas.drawColor(Color.RED)

    }
}