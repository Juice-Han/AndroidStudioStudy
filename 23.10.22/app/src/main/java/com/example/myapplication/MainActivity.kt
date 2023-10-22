package com.example.myapplication

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val sb = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myView.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                handleTouch(event)
                return true
            }
        })
    }

    private fun handleTouch(m: MotionEvent?){
        var x:Float? = m?.x
        var y:Float? = m?.y

        when (m?.action){
            MotionEvent.ACTION_DOWN -> sb.append("손가락 누름 $x, $y\n")
            MotionEvent.ACTION_MOVE -> sb.append("손가락 이동 $x, $y\n")
            MotionEvent.ACTION_UP -> sb.append("손가락 뗌 $x, $y\n")
            else -> sb.append("\n")
        }
        binding.textView.text = sb.toString()
    }
}