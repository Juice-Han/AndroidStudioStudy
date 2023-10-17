package com.example.xml_layout_kotlin_code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myText = TextView(this)
        myText.text = "안녕, 안드로이드 13"
        myText.textSize = 24f
        myText.id = R.id.myText

        val myLayout = ConstraintLayout(this)
        setContentView(myLayout)

        val set = ConstraintSet()
        set.constrainHeight(myText.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(myText.id, ConstraintSet.WRAP_CONTENT)

        set.connect(myText.id, ConstraintSet.START,
            ConstraintSet.PARENT_ID, ConstraintSet.START,0)
        set.connect(myText.id, ConstraintSet.END,
            ConstraintSet.PARENT_ID, ConstraintSet.END,0)
        set.connect(myText.id, ConstraintSet.TOP,
            ConstraintSet.PARENT_ID, ConstraintSet.TOP,0)
        set.connect(myText.id, ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,0)
        set.applyTo(myLayout)

        val myButton = Button(this)
        myButton.text = "Button"
        myButton.textSize = 20f
        myButton.isAllCaps = false
        myButton.id = R.id.myButton

        myLayout.addView(myText)
        myLayout.addView(myButton)
        setContentView(myLayout)

        set.constrainHeight(myButton.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(myButton.id, ConstraintSet.WRAP_CONTENT)

        set.connect(myButton.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START,0)
        set.connect(myButton.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END,0)
        set.connect(myButton.id, ConstraintSet.TOP, myText.id, ConstraintSet.BOTTOM,64)
        set.applyTo(myLayout)
    }
}