package com.vipuldamor87.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.*
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var color : Int = 0
    private var x : Int = 0
    private var y : Int = 0
    private var views : MutableList<View> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        cv.setOnClickListener {
            color = RED
            canvas.setColorCode(color) }
        cv2.setOnClickListener {
            color = GREEN
            canvas.setColorCode(color)
        }
        cv3.setOnClickListener {
            color = BLUE
            canvas.setColorCode(color)
        }
        cv4.setOnClickListener {
            color = BLACK
            canvas.setColorCode(color)
        }
        canvas.setOnTouchListener { v, event ->
            x = event.x.toInt()
            y = event.y.toInt()
            when (event.action) {

                MotionEvent.ACTION_UP -> {
                    Log.d("EVENT","UP")
                    views.add(DrawView(this,color))
                    canvas.addShape(Rectangle(event.x,event.y,event.x+100,event.y+100, color))
                    Log.d("EVENT",x.toString())
                    Log.d("EVENT",y.toString())

                }
            }
            true
        }
    }
        class DrawView(context: Context?,var color:Int) : View(context) {
            var paint: Paint = Paint()
            override fun onDraw(canvas: Canvas) {
                paint.color = color
                canvas.drawRect(20F + x, 20F + y, 60F, 60F, paint)

            }
    }
}