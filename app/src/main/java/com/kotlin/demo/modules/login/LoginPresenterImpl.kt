package com.kotlin.demo.modules.login

import android.content.Context
import com.kotlin.demo.api.WanAndroidApi
import com.kotlin.demo.beans.LoginRegisterResponse
import com.kotlin.demo.modules.login.inter.LoginPresenter
import com.kotlin.demo.modules.login.inter.LoginView
import com.kotlin.demo.network.ApiClient
import com.kotlin.demo.network.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//Presenter层 实现
class LoginPresenterImpl(private val loginView: LoginView?) : LoginPresenter,
    LoginPresenter.OnLoginListener {

    // 需要M 去请求服务器
//    private val loginModel: LoginModelImpl
    // 需要V 去更新Activity/Fragment
    override fun loginAction(context: Context, username: String, password: String) {
        //                mvc实现
        //Java WanAndroidAPI.class --- WanAndroidAPI::class.java
                val api: WanAndroidApi =
                    ApiClient.instance.instanceRetrofit(WanAndroidApi::class.java)
                api.loginAction(username, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : ApiResponse<LoginRegisterResponse>(context){
                        override fun onSuccess(data: LoginRegisterResponse?) {
                            loginView?.loginSuccess(data)
                        }

                        override fun onFailed(msg: String?) {
                            loginView?.loginFailed(msg)
                        }

                    })
    }


    override fun unAttachView() {
//        loginView? = null;
    }

    override fun loginSuccess(loginBean: LoginRegisterResponse?) {
        loginView?.loginSuccess(loginBean)
    }

    override fun loginFailed(message: String) {
        loginView?.loginFailed(message)
    }

}