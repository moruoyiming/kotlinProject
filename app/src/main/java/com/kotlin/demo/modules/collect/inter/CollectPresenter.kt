package com.kotlin.demo.modules.collect.inter

import com.kotlin.demo.base.IBasePresenter
import com.kotlin.demo.database.Article

interface CollectPresenter :IBasePresenter {

    fun requestInsert(vararg article: Article);

    fun requestUpdate(vararg article: Article);

    fun requestDelete(vararg article: Article);

    fun requestDeleteAll();

    fun requestQueryAll();


    //监听回调
    interface OnCollectListener {

        fun showUI(result: Boolean)

    }

    interface OnCollectResponseListener{
        fun showResultSuccess(result: List<Article>?)
    }
}