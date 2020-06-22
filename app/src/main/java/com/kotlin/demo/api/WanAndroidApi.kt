package com.kotlin.demo.api

import com.kotlin.demo.beans.LoginRegisterResponse
import com.kotlin.demo.beans.LoginResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

//客户端API 可以访问服务器的APi
interface WanAndroidApi {

    //登录 https://www.wanandroid.com/user/login
    @POST("/user/login")
    @FormUrlEncoded
    fun loginAction(
        @Field("username") username: String,
        @Field("password") password: String
    ): Observable<LoginResponseWrapper<LoginRegisterResponse>>

    //注册 https://www.wanandroid.com/user/register
    @POST("/user/register")
    @FormUrlEncoded
    fun registerAction(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    )
            : Observable<LoginResponseWrapper<LoginRegisterResponse>>


    // 首页文章列表 https://www.wanandroid.com/article/list/0/json
    @GET("/article/list/0/json")
    @FormUrlEncoded
    fun articleAction(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    )
            : Observable<LoginResponseWrapper<LoginRegisterResponse>>

    //首页banner https://www.wanandroid.com/banner/json
    @GET("/banner/json")
    @FormUrlEncoded
    fun bannerAction(
        @Field("username") username: String
    )
            : Observable<LoginResponseWrapper<LoginRegisterResponse>>
}