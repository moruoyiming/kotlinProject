package com.kotlin.demo.network

import android.content.Context
import com.kotlin.demo.beans.LoginResponseWrapper
import com.kotlin.demo.config.LoadingDialog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

//拦截 自定义操作符 目的 包装bean 拆分 成功 data-> UI  失败 msg -> UI
abstract class ApiResponse<T>(val context: Context) : Observer<LoginResponseWrapper<T>> {

    private var isShowLoading: Boolean = true

    // 次构造
    constructor(context: Context, isShow: Boolean = false) : this(context) {
        this.isShowLoading = isShow
    }

    abstract fun onSuccess(data: T?);

    abstract fun onFailed(msg: String?);

    override fun onSubscribe(d: Disposable) {
        if (isShowLoading) {
            LoadingDialog.show(context)
        }
    }

    override fun onNext(t: LoginResponseWrapper<T>) {
        if (t.errorCode == 0) {
            onSuccess(t.data)
        } else {
            onFailed("登录失败,msg " + t.errorMsg);
        }

    }

    override fun onError(e: Throwable) {
        if (isShowLoading) {
            LoadingDialog.cancel()
        }
        onFailed(e.message);
    }

    override fun onComplete() {
        if (isShowLoading) {
            LoadingDialog.cancel()
        }
    }
}