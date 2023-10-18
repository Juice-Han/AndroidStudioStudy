package com.example.event_handler

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton = findViewById<Button>(R.id.button)
        myButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val s: String = "안녕, 안드로이드 13!"
        var myTextView = findViewById<TextView>(R.id.textView)
        myTextView.text = s
    }


}