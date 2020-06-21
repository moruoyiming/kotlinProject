package com.kotlin.demo.modules.login.inter

import android.content.Context
import com.kotlin.demo.base.IBasePresenter
import com.kotlin.demo.beans.LoginResponse

//中间层
interface LoginPresenter : IBasePresenter {

    //登录
    fun loginAction(context: Context, username: String, password: String)

    //监听回调
    interface OnLoginListener {

        fun loginSuccess(loginBean: LoginResponse?)

        fun loginFailed(message: String);

    }
}