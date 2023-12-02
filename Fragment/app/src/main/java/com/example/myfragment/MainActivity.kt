package com.example.myfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment: Fragment? =
            supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(fragment == null){
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragment_container,FragmentA())
                addToBackStack(null)
                commit()
            }
        }
        binding.button.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, FragmentA())
                addToBackStack(null)
                commit()
            }
        }
        binding.button2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragment_container, FragmentB())
                addToBackStack(null)
                commit()
            }
        }
    }
}