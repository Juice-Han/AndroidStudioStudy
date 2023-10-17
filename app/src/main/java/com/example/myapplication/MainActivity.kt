package com.example.myapplication

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var cnt = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClicked(view : View){
        var imageView1 : ImageView = findViewById<ImageView>(R.id.imageView1)
        var imageView2 : ImageView = findViewById<ImageView>(R.id.imageView2)

        imageView1.visibility = View.INVISIBLE
        imageView2.visibility = View.INVISIBLE

        cnt += 1

        when(cnt%2){
            0 -> imageView1.visibility = View.VISIBLE
            1 -> imageView2.visibility = View.VISIBLE
        }
    }

}