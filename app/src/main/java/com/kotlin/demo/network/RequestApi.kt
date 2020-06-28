package com.kotlin.demo.network

import okhttp3.OkHttpClient

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
        url: String, resultData: NetWorkResultData, vararg value: String
    ) {
        val okHttpClient = OkHttpClient();

    }

}