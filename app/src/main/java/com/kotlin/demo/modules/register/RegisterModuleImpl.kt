package com.kotlin.demo.modules.register

import android.content.Context
import com.kotlin.demo.api.WanAndroidApi
import com.kotlin.demo.beans.LoginRegisterResponse
import com.kotlin.demo.modules.register.inter.RegisterModule
import com.kotlin.demo.modules.register.inter.RegisterPersenter
import com.kotlin.demo.network.ApiClient
import com.kotlin.demo.network.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterModuleImpl : RegisterModule {

    // 取消请求
    override fun cancelRequest() {}

    override fun register(
        context: Context,
        username: String,
        password: String,
        repassword: String,
        callback: RegisterPersenter.OnRegisterListener
    ) {
        // 网络模型
        ApiClient.instance.instanceRetrofit(WanAndroidApi::class.java)
            .registerAction(username, password, repassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiResponse<LoginRegisterResponse>(context) {

                override fun onSuccess(data: LoginRegisterResponse?) {
                    callback.registerSuccess(data)
                }

                override fun onFailed(msg: String?) {
                    callback.registerFailed(msg)
                }

            })
    }
}