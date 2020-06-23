package com.kotlin.demo.modules.login.inter

import com.kotlin.demo.beans.LoginRegisterResponse

//View层
interface LoginView {
    //把结果返回给Activity / Fragemnt

    fun loginSuccess(loginBean: LoginRegisterResponse ?)

    fun loginFailed(message: String?);

}