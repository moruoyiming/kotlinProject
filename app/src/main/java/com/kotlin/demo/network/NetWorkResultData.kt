package com.kotlin.demo.network

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

abstract class NetWorkResultData : Callback {
    override fun onFailure(call: Call, e: IOException) {
        requestError("")
        Handler(Looper.getMainLooper(), object : Handler.Callback {
            override fun handleMessage(msg: Message): Boolean {
                e.message?.let { msg }
                return false
            }

        }).sendEmptyMessage(0)
    }

    override fun onResponse(call: Call, response: Response) {
        TODO("Not yet implemented")
    }

    abstract fun requestError(info: String);

    abstract fun requestSuccess(result: Response);
}