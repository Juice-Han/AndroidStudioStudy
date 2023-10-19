package com.example.event_handler_practice

import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import com.example.event_handler_practice.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dp = 16
        var scale : Float = resources.displayMetrics.density
        val method3_messege = getString(R.string.method3_messege)

        binding.button.setOnClickListener{
            val px : Int = (scale * dp + 0.5).toInt()
            var s = "method1 > dp=$dp, px=$px"
            binding.textView.text = s
        }

        binding.button2.setOnClickListener{
            val px : Int = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
                resources.displayMetrics).toInt()
            val msg = "method2 > dp=$dp, px=$px"
            binding.textView.text = msg
        }

        binding.button3.setOnClickListener{
            val px : Int = (scale * dp).roundToInt()
            binding.textView.text = String.format(method3_messege,dp,px)
        }
    }
}