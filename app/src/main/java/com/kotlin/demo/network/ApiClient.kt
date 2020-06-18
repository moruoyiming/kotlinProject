package com.kotlin.demo.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * <pre>
 *     author: jian
 *     Date  : 2020/6/18 8:18 PM
 *     Description:
 * </pre>
 */
class ApiClient {
    private object Holder {
        val INSTANCE = ApiClient()
    }

    companion object {
        val instance = Holder.INSTANCE
    }

    fun <T> instanceRetrofit(apiInterface: Class<T>): T {
        //OkhttpClient请求服务器
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.readTimeout(10000,TimeUnit.MILLISECONDS)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("")
        //请求方
            .client()

        return null
    }
}