package com.kotlin.demo.base

interface IBasePresenter {

//    fun attachView()

    // 试图离开(Activity/Fragment)销毁
    fun unAttachView()
}