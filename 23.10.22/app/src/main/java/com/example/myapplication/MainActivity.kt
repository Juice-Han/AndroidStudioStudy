package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myButton.setOnClickListener{
            Toast.makeText(
                applicationContext, "Button is pressed", Toast.LENGTH_SHORT)
                .show()
            binding.myTextView.text = "Button is pressed"
        }

        binding.myButton.setOnLongClickListener{
            Toast.makeText(
                applicationContext, "Long Button click", Toast.LENGTH_SHORT).show()
            binding.myTextView.text = "Long Button click"
            false
        }
    }
}