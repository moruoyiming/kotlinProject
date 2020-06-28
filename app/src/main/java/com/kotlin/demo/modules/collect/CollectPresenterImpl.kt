package com.kotlin.demo.modules.collect

import com.kotlin.demo.database.Article
import com.kotlin.demo.modules.collect.inter.CollectModule
import com.kotlin.demo.modules.collect.inter.CollectPresenter
import com.kotlin.demo.modules.collect.inter.CollectView

class CollectPresenterImpl(var view: CollectView?) : CollectPresenter,
    CollectPresenter.OnCollectListener, CollectPresenter.OnCollectResponseListener {

    private val model: CollectModule = CollectModuleImpl();

    override fun requestInsert(vararg article: Article) {
        // * 把参数取出传递
        model.requestInsert(this,*article)
    }

    override fun requestUpdate(vararg article: Article) {
        model.requestUpdate(this,*article)
    }

    override fun requestDelete(vararg article: Article) {
        model.requestDelete(this,*article)
    }

    override fun requestDeleteAll() {
    }

    override fun requestQueryAll() {
    }

    override fun unAttachView() {
    }

    override fun showUI(result: Boolean) {
    }

    override fun showResultSuccess(result: List<Article>?) {
    }

}