package com.example.event_handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton = findViewById<Button>(R.id.button)
        val lis = myListener()
        myButton.setOnClickListener(lis)
    }

    inner class myListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            val s : String = "안녕, 안드로이드 12!"
            var myTextView = findViewById<TextView>(R.id.textView)
            myTextView.text = s
        }
    }
}