package com.gmail.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Rectangle @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private val myShape = Paint().apply {
        style = Paint.Style.STROKE
    }
    private var cornerRadius = 100F

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Rectangle,
            0, 0
        ).apply {
            try {
                myShape.strokeWidth = getFloat(R.styleable.Rectangle_border_width, 30F)
                myShape.color = getColor(R.styleable.Rectangle_border_color, Color.GREEN)
                cornerRadius = getFloat(R.styleable.Rectangle_corner_radius, cornerRadius)
            } finally {
                recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val offset = myShape.strokeWidth / 2
        canvas.drawRoundRect(
            offset,
            offset,
            width.toFloat() - offset,
            height.toFloat() - offset,
            cornerRadius,
            cornerRadius,
            myShape
        )
    }
}