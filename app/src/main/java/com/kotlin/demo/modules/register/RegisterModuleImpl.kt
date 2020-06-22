package com.xiangxue.kotlinproject.modules.register

import android.content.Context
import com.xiangxue.kotlinproject.api.WanAndroidAPI
import com.xiangxue.kotlinproject.entity.LoginRegisterResponse
import com.kotlin.demo.modules.register.inter.RegisterModule
import com.kotlin.demo.modules.register.inter.RegisterPersenter
import com.xiangxue.kotlinproject.net.APIClient
import com.xiangxue.kotlinproject.net.APIResponse
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
        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            .registerAction(username, password, repassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APIResponse<LoginRegisterResponse>(context) {
                override fun success(data: LoginRegisterResponse?) {
                    callback.registerSuccess(data)
                }

                override fun failure(errorMsg: String?) {
                    callback.registerFailed(errorMsg)
                }

            })
    }
}