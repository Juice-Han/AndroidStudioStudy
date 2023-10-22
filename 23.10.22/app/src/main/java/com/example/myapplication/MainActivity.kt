package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myButton.setOnClickListener{
            binding.myTextView.text = "Button Clicked"
        }

        binding.myButton.setOnLongClickListener{
            binding.myTextView.text = "Long Button Clicked"
            true //람다식은 return을 생략한다.
            //리턴값이 false일 때 마우스를 길게 눌렀다가 때면 Button Clicked로 돌아간다.
        }
    }
}