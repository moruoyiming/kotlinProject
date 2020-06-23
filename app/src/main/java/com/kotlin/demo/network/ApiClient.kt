package com.kotlin.demo.network

import com.kotlin.demo.Flag
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 访问服务器的API接口的客户端管理
 */
class ApiClient {
    private object Holder {
        val INSTANCE = ApiClient()
    }

    //派生
    companion object {
        val instance = Holder.INSTANCE
    }

    //动态代理创建 WanAndroidAPI接口
    fun <T> instanceRetrofit(apiInterface: Class<T>): T {
        //OkhttpClient请求服务器
        val okHttpClient = OkHttpClient().newBuilder()
            .readTimeout(10,TimeUnit.SECONDS)
            .connectTimeout(10,TimeUnit.SECONDS)
            .writeTimeout(10,TimeUnit.SECONDS)
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Flag.BASE_URL)
            //请求方  <-
            .client(okHttpClient)
            //响应方  ->
            //Response 返回数据
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(apiInterface)
    }
}