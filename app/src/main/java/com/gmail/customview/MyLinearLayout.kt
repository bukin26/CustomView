package com.gmail.customview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding

class MyLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : LinearLayout(context, attrs, defaultStyle) {

    private var myTextColor = Color.WHITE
    private var myBackgroundColor = Color.BLACK
    private var myTextSize = context.resources.getDimension(R.dimen.my_text_view_size)

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MyLinearLayout,
            0, 0
        ).apply {
            try {
                myTextColor = getColor(
                    R.styleable.MyLinearLayout_text_color,
                    myTextColor
                )
                myBackgroundColor = getColor(
                    R.styleable.MyLinearLayout_background_color,
                    myBackgroundColor
                )
                myTextSize = getDimension(
                    R.styleable.MyLinearLayout_text_size,
                    myTextSize
                )
            } finally {
                recycle()
            }
        }
    }

    fun addItem(text: String) {
        val myTextView = TextView(context).apply {
            setPadding(context.resources.getDimensionPixelSize(R.dimen.my_text_view_padding))
            setTextColor(myTextColor)
            setBackgroundColor(myBackgroundColor)
            setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                myTextSize
            )
            setText(text)
        }
        addView(myTextView)
    }
}