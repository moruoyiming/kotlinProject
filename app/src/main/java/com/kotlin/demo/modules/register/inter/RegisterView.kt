package com.kotlin.demo.modules.register.inter

import com.kotlin.demo.beans.LoginRegisterResponse


interface RegisterView {

    // 成功 失败 显示 到 Activty

    fun registerSuccess(registerBean: LoginRegisterResponse?)

    fun registerFailed(errorMsg: String?)


}