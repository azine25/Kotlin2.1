package com.geek.kotlin21.ui.fragments

import android.telecom.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geek.kotlin21.core.App
import com.geek.kotlin21.model.TriviaCategories
import javax.security.auth.callback.Callback

class MainViewModel : ViewModel() {

    private var counter = MutableLiveData<Int>()
    private var count = 0

    fun setCount() {
        count++
        counter.postValue(count)
    }

    fun getCount(): MutableLiveData<Int> {
        return counter
    }

}