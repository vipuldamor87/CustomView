package com.vipuldamor87.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.shapes.Shape
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

class CustomViewDraw : View {
    var canvas: Canvas? = null
    var shapes: ArrayList<Shape> = ArrayList()
    var color : Int = Color.GREEN
    private var drawPaint: Paint? = null

    constructor(context: Context?) : super(context) {
        invalidate()
    }

    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {
        drawPaint = Paint()
        drawPaint!!.color = color
        invalidate()
    }



    fun setColorCode(colorCode : Int)
    {
        this.color = colorCode
        drawPaint!!.color = colorCode
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (i in shapes)
        {
            var rectangle = i as Rectangle
            drawPaint!!.color = i.color
            drawPaint?.let { canvas.drawRect(i.left,i.top,i.right,i.bottom, it) }
        }
        invalidate()
    }


    fun addShape(newShape: Shape) {
        shapes.add(newShape)
        invalidate()
    }

    fun clearShapes() {
        shapes.clear()
        invalidate()
    }
}