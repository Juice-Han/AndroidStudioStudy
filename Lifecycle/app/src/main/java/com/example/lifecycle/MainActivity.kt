package com.example.lifecycle

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycle.databinding.ActivityMainBinding

const val TAG = "Orientation"
private const val KEY_NAME = "last_name"
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        setContentView(binding.root)
        Log.d(TAG,"onCreate() 호출")

        binding.nameEditText.setText(viewModel.usrName)
        binding.confirmButton.setOnClickListener{
            viewModel.saveUsrName(binding.nameEditText.text.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState() 호출")

        val usrName = binding.nameEditText.text.toString()
        outState.putString(KEY_NAME, usrName)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG,"onRestoreInstanceState() 호출")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() 호출")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause() 호출")

        val settings = getPreferences(MODE_PRIVATE)
        val editor : SharedPreferences.Editor = settings.edit()
        val usrName = binding.nameEditText.text.toString()
        editor.putString(KEY_NAME,usrName)
        editor.commit()
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

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume() 호출")
    }
}