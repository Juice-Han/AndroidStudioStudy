package com.example.intents

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intents.databinding.ActivityMainBinding

const val MY_STRING = "my_string"
const val MY_INT = "my_int"
const val RETURN_MESSAGE = "com.example.intents.RETURN_MESSAGE"
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var subIntent = Intent(this@MainActivity, SubActivity::class.java)
            subIntent.apply {
                val str = binding.editTextText.text.toString()
                putExtra(MY_STRING, str)
                putExtra(MY_INT, 13)
            }
            startForResult.launch(subIntent)
        }
    }
    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {result ->
                if(result?.resultCode == Activity.RESULT_OK){
                    result.data?.let {
                        val extras: Bundle? = result.data!!.extras
                        val returnStr = extras?.getString(RETURN_MESSAGE) ?: ""
                        binding.editTextText.setText(returnStr)
                    }
                }
    }
}