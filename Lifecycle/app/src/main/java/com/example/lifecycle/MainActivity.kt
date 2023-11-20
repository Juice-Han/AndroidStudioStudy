package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lifecycle.databinding.ActivityMainBinding

private const val TAG = "Orientation"
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"onCreate() 호출")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() 호출")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause() 호출")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() 호출")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() 호출")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart() 호출")
    }
}