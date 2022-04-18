package com.gmail.customview

import android.annotation.SuppressLint
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

    private val rectangle = Paint().apply {
        style = Paint.Style.STROKE
    }
    private var cornerRadius = 100F

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Square,
            0, 0
        ).apply {
            try {
                rectangle.strokeWidth = getFloat(R.styleable.Square_border_width, 30F)
                rectangle.color = getColor(R.styleable.Square_border_color, Color.GREEN)
                cornerRadius = getFloat(R.styleable.Square_corner_radius, cornerRadius)
            } finally {
                recycle()
            }
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRoundRect(
            30F,
            30F,
            width.toFloat() - 30F,
            height.toFloat() - 30F,
            cornerRadius,
            cornerRadius,
            rectangle
        )
    }
}