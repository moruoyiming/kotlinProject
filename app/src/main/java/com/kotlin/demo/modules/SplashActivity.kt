package com.kotlin.demo.modules

import com.kotlin.demo.base.BaseActivity
import com.kotlin.demo.modules.login.inter.LoginPresenter

class SplashActivity :BaseActivity<LoginPresenter>(){
    override fun createPresenter(): LoginPresenter {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun recycle() {
        TODO("Not yet implemented")
    }
}