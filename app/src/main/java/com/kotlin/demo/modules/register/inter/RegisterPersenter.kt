package com.kotlin.demo.modules.register.inter

import android.content.Context
import com.kotlin.demo.base.IBasePresenter
import com.kotlin.demo.beans.LoginRegisterResponse

interface RegisterPersenter : IBasePresenter {

    fun registerWanAndroid(context: Context, username: String, password: String, repassword: String)

    // M  ---》 P  接口监听
    interface OnRegisterListener {

        fun registerSuccess(registerBean: LoginRegisterResponse?)

        fun registerFailed(errorMsg: String?)

    }

}