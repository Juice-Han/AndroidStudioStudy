package com.example.myfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myfragment.databinding.FragmentBBinding

class FragmentB : Fragment() {
    var activityCallback : ButtonListenerB? = null
    interface ButtonListenerB {
        fun onButtonClickB()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBBinding.inflate(inflater,container,false)
        binding.button4.setOnClickListener {
            activityCallback?.onButtonClickB()
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            if(context is ButtonListenerB){
                activityCallback = context
            }
        }catch (e : Exception){
            return
        }
    }
}