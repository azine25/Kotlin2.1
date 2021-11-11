package com.geek.kotlin21.core

import android.app.Application
import com.geek.kotlin21.data.remote.RetrofitClient

class App : Application() {

    companion object {
        val client = RetrofitClient.create()
    }


}