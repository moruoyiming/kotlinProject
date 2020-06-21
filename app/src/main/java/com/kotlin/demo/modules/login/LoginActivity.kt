package com.kotlin.demo.modules.login

import android.util.Log
import android.view.View
import android.widget.Toast
import com.kotlin.demo.R
import com.kotlin.demo.base.BaseActivity
import com.kotlin.demo.beans.LoginResponse
import com.kotlin.demo.modules.login.inter.LoginPresenter
import com.kotlin.demo.modules.login.inter.LoginView
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
                val userName = user_phone_et.text.toString()
                val password = user_password_et.text.toString()
                Log.d("TAG", "userName:$userName ,password: $password")
                presenter.loginAction(this, userName, password)
//                mvc实现
                //Java WanAndroidAPI.class --- WanAndroidAPI::class.java
//                val api: WanAndroidApi =
//                    ApiClient.instance.instanceRetrofit(WanAndroidApi::class.java)
//
//                api.loginAction(userName, userPwd)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe()

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

    override fun loginSuccess(loginBean: LoginResponse?) {
        Toast.makeText(this, "login success", Toast.LENGTH_LONG).show()
    }

    override fun loginFailed(message: String) {
        Toast.makeText(this, "login failed", Toast.LENGTH_LONG).show()
    }

    override fun recycle() {
    }

}