package com.gmail.customview

import android.annotation.SuppressLint
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

    fun addItem(text: String) {
        val textView = TextView(context).apply {
            setBackgroundColor(Color.BLACK)
            setTextColor(Color.WHITE)
            setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                context.resources.getDimension(R.dimen.my_text_view_size)
            )
            setPadding(context.resources.getDimensionPixelSize(R.dimen.my_text_view_padding))
            setText(text)
        }
        addView(textView)
    }
}