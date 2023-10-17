package com.example.xml_layout_kotlin_code

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton = findViewById<Button>(R.id.button2)
        val myTextView = findViewById<TextView>(R.id.textView2)

        myTextView.text = "Welcome to android world!"
        myTextView.textSize = 24f
        myTextView.setTypeface(null, Typeface.BOLD)

        myButton.setBackgroundColor(Color.BLUE)
        myButton.text = "Press me"
        myButton.textSize = 20f
        myButton.setTypeface(null,Typeface.ITALIC)
    }
}