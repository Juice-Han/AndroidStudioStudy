package com.example.lifecycle

import android.util.Log
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    init {
        Log.d(TAG,"MyViewModel created")
    }
    private var _usrName = ""

    val usrName: String
        get() = _usrName

    fun saveUsrName(str: String){
        _usrName = str
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"MyViewModel cleared")
    }
}