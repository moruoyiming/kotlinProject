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
        model.requestInsert(this, *article)
    }

    override fun requestUpdate(vararg article: Article) {
        model.requestUpdate(this, *article)
    }

    override fun requestDelete(vararg article: Article) {
        model.requestDelete(this, *article)
    }

    override fun requestQuery(vararg article: Article) {
        model.requestQuery(this, *article)
    }

    override fun requestDeleteAll() {
        model.requestDeleteAll(this)
    }

    override fun requestQueryAll() {
        model.requestQueryAll(this)
    }

    override fun unAttachView() {
        view = null
    }


    override fun showUI(result: Boolean) {
        view?.showResult(result)
    }

    override fun showResultSuccess(result: List<Article>?) {
        view?.onSuccess(result)
    }

}