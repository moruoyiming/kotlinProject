package com.kotlin.demo.network

interface IRequest {

    fun instanceRequestAction(url: String, value: String, resultData: NetWorkResultData)


    fun instanceRequestAction1(
        url: String,
        value: String,
        value1: String,
        resultData: NetWorkResultData
    )

    fun instanceRequestAction2(
        url: String,
        value: String,
        value1: String,
        value2: String,
        resultData: NetWorkResultData
    )
}