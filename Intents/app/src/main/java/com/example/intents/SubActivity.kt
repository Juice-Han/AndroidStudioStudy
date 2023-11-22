package com.example.intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intents.databinding.ActivityMainBinding
import com.example.intents.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val extras: Bundle = intent.extras ?: return
        val qString = extras.getString(MY_STRING)
        val qInt = extras.getInt(MY_INT)
        binding.editTextText2.setText(qString + qInt.toString())

        binding.button2.setOnClickListener{
            val returnStr = binding.editTextText2.text.toString()
            val data = Intent()
            data.putExtra(RETURN_MESSAGE,returnStr)
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}