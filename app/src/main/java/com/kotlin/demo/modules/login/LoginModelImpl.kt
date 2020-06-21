package com.kotlin.demo.modules.login

import android.content.Context
import com.kotlin.demo.modules.login.inter.LoginModule
import com.kotlin.demo.modules.login.inter.LoginPresenter

class LoginModelImpl : LoginModule{

    override fun cancelRequest() {
        TODO("Not yet implemented")
    }

    override fun login(
        context: Context,
        username: String,
        password: String,
        listener: LoginPresenter.OnLoginListener
    ) {
        TODO("Not yet implemented")
    }
}