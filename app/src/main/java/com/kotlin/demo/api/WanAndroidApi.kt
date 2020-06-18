package com.kotlin.demo.api

import com.kotlin.demo.beans.LoginResponse
import com.kotlin.demo.beans.LoginResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.POST

/**
 * <pre>
 *     author: jian
 *     Date  : 2020/6/18 8:14 PM
 *     Description:
 * </pre>
 */
interface WanAndroidApi {

    @POST("/user/login")
    fun loginAction(
        @Field("username") username: String,
        @Field("userpwd") userpwd: String
    )
    : Observable<LoginResponseWrapper<LoginResponse>>
}