package com.kotlin.demo.modules.login

import android.util.Log
import android.view.View
import android.widget.Toast
import com.kotlin.demo.R
import com.kotlin.demo.api.WanAndroidApi
import com.kotlin.demo.base.BaseActivity
import com.kotlin.demo.beans.LoginRegisterResponse
import com.kotlin.demo.modules.login.inter.LoginPresenter
import com.kotlin.demo.modules.login.inter.LoginView
import com.kotlin.demo.network.ApiClient
import com.kotlin.demo.network.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 违背单一原则  C  V  M
 * MVVM + JetPack
 * 登录界面
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

//    lateinit var p: LoginPresenter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//        user_login_bg.setOnClickListener(onClickListener)
//
//    }

    private val onClickListener = View.OnClickListener { view ->
        //id  内部根据 = 知道是要setId  否则  getId
        when (view.id) {
            R.id.user_login_bg -> {
                val username = user_phone_et.text.toString()
                val password = user_password_et.text.toString()
                Log.d("TAG", "username:$username ,password: $password")
                presenter.loginAction(this, username, password)
//                mvc实现
                //Java WanAndroidAPI.class --- WanAndroidAPI::class.java
//                val api: WanAndroidApi =
//                    ApiClient.instance.instanceRetrofit(WanAndroidApi::class.java)
//                api.loginAction(username, password)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(object : ApiResponse<LoginRegisterResponse>(this) {
//                        override fun onSuccess(data: LoginRegisterResponse?) {
//                            TODO("Not yet implemented")
//                        }
//
//                        override fun onFailed(msg: String?) {
//                            TODO("Not yet implemented")
//                        }
//
//                    })
//                    .subscribe(object : Consumer<LoginResponseWrapper<LoginResponse>> {
//                        override fun accept(t: LoginResponseWrapper<LoginResponse>) {
//                        }
//                    })
            }

        }

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        user_login_bg.setOnClickListener(onClickListener)
    }

    override fun createPresenter(): LoginPresenter {
        return LoginPresenterImpl(this);
    }

    override fun loginSuccess(loginBean: LoginRegisterResponse?) {
        Toast.makeText(this, "login success", Toast.LENGTH_LONG).show()
    }

    override fun loginFailed(message: String?) {
        Toast.makeText(this, "login failed", Toast.LENGTH_LONG).show()
    }

    override fun recycle() {
    }

}