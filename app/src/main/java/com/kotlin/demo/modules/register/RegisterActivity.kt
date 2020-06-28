package com.kotlin.demo.modules.register

import android.widget.Toast
import com.kotlin.demo.R
import com.kotlin.demo.base.BaseActivity
import com.kotlin.demo.beans.LoginRegisterResponse
import com.kotlin.demo.modules.register.inter.RegisterPersenter
import com.kotlin.demo.modules.register.inter.RegisterView
import kotlinx.android.synthetic.main.activity_user_register.*


class RegisterActivity : BaseActivity<RegisterPersenter>(), RegisterView {


    override fun createPresenter(): RegisterPersenter = RegisterPresenterImpl(this)

    override fun recycle() {
        presenter.unAttachView()
    }

    override fun registerSuccess(registerBean: LoginRegisterResponse?) {
        Toast.makeText(this, "注册成功😀", Toast.LENGTH_SHORT).show()
    }

    override fun registerFailed(errorMsg: String?) {
        Toast.makeText(this, "注册失败 ~ 呜呜呜", Toast.LENGTH_SHORT).show()
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_user_register
    }

    override fun initView() {
        user_register_bt.setOnClickListener {
            //调用注册
            val usernameStr = user_phone_et.text.toString()
            val passwordStr = user_password_et.text.toString()
            presenter.registerWanAndroid(this@RegisterActivity, usernameStr, passwordStr, passwordStr)
        }
    }
}