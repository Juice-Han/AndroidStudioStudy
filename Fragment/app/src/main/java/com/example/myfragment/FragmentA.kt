package com.example.myfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myfragment.databinding.FragmentABinding

class FragmentA : Fragment() {
    var activityCallback : ButtonListener? = null
    interface ButtonListener {
        fun onButtonClick()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentABinding.inflate(inflater,container,false)
        binding.button3.setOnClickListener {
            activityCallback?.onButtonClick()
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            if(context is ButtonListener)
                activityCallback = context
        }catch (e: Exception){
            return
        }
    }
}