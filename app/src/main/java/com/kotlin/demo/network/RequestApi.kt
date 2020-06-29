package com.kotlin.demo.network

import com.kotlin.demo.config.Flag
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request

object RequestApi : IRequest {
    override fun instanceRequestAction(url: String, value: String, resultData: NetWorkResultData) {
        commonOkHttpRequestAction(url, resultData, value)
    }

    override fun instanceRequestAction1(
        url: String,
        value: String,
        value1: String,
        resultData: NetWorkResultData
    ) {
        commonOkHttpRequestAction(url, resultData, value, value1)
    }

    override fun instanceRequestAction2(
        url: String,
        value: String,
        value1: String,
        value2: String,
        resultData: NetWorkResultData
    ) {
        commonOkHttpRequestAction(url, resultData, value, value1, value2)
    }


    fun commonOkHttpRequestAction(
        url: String,
        resultData: NetWorkResultData,
        vararg values: String
    ) {
        // 1.创建一个OkhttpClient对象
        val okHttpClient = OkHttpClient();
        // 2.构建参数的body  MultipartBody.FORM 表单形式
        val builder: MultipartBody.Builder = MultipartBody.Builder().setType(MultipartBody.FORM)
        // 参数根据可变参数的 数量变化而变化
        for (value in values) {
            // 2.2 封装参数
            builder.addFormDataPart(Flag.PART, value)
        }
        // 3.构建一个请求  post 提交里面是参数的builder   url()请求路径
        val request: Request = Request.Builder().url(url)
            .post(builder.build()).build()

        // 4.发送一个请求  给服务器
        okHttpClient.newCall(request).enqueue(resultData)
    }

}