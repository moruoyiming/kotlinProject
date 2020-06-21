package com.kotlin.demo.modules.login.inter

import com.kotlin.demo.beans.LoginResponse

//View层
interface LoginView {
    //把结果返回给Activity / Fragemnt

    fun loginSuccess(loginBean: LoginResponse ?)

    fun loginFailed(message: String);

}