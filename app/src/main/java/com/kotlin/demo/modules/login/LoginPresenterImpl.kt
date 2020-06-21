package com.kotlin.demo.modules.login

import android.content.Context
import com.kotlin.demo.beans.LoginResponse
import com.kotlin.demo.modules.login.inter.LoginPresenter
import com.kotlin.demo.modules.login.inter.LoginView

//Presenter层 实现
class LoginPresenterImpl(private val loginView: LoginView?) : LoginPresenter,
    LoginPresenter.OnLoginListener {

    // 需要M 去请求服务器
//    private val loginModel: LoginModelImpl
    // 需要V 去更新Activity/Fragment
    override fun loginAction(context: Context, username: String, password: String) {
        TODO("Not yet implemented")
    }


    override fun unAttachView() {
//        loginView? = null;
    }

    override fun loginSuccess(loginBean: LoginResponse?) {
        loginView?.loginSuccess(loginBean)
    }

    override fun loginFailed(message: String) {
        loginView?.loginFailed(message)
    }

}