package com.kotlin.demo.modules.login.inter

import android.content.Context

//module
 interface LoginModule {
    //取消请求 动作
    fun cancelRequest()

    //登录
    fun login(
        context: Context,
        username: String,
        password: String,
        //接口回调 由p层传递过来
        listener: LoginPresenter.OnLoginListener
    )
}