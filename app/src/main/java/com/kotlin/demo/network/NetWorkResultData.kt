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
        Handler(Looper.getMainLooper(), object : Handler.Callback {
            override fun handleMessage(msg: Message): Boolean {
                e.message?.myLet {
                    requestError(this)
                }
                return false
            }

        }).sendEmptyMessage(0)
    }

    override fun onResponse(call: Call, response: Response) {
        // 在主线程 执行
        Handler(Looper.getMainLooper(), Handler.Callback {
            requestSuccess(response)
            false  // 正常执行下去 false
        }).sendEmptyMessage(0)
    }

    abstract fun requestError(info: String);

    abstract fun requestSuccess(result: Response);

    fun <T, R> T.myLet(mm: T.(T) -> R): R {
        // T == this
        // mm(this) == this
        return mm(this)
    }
}