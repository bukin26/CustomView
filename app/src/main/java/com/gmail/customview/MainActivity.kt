package com.gmail.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayout: MyLinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout = findViewById(R.id.my_linear_layout)
        linearLayout.addItem("first")
        linearLayout.addItem("second")
        linearLayout.addItem("third")
    }
}