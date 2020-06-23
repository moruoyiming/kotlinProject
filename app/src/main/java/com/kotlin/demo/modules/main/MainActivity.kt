package com.kotlin.demo.modules.main

import com.kotlin.demo.R
import com.kotlin.demo.base.BaseActivity
import com.kotlin.demo.modules.login.LoginPresenterImpl
import com.kotlin.demo.modules.main.inter.MainPresenter
import com.kotlin.demo.modules.main.inter.MainView

class MainActivity : BaseActivity<MainPresenter>() , MainView {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenterImpl(this);
    }

    override fun recycle() {
    }
}