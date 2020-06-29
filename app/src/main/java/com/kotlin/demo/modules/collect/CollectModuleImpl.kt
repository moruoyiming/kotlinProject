package com.kotlin.demo.modules.collect

import android.util.Log
import com.kotlin.demo.config.Flag
import com.kotlin.demo.database.Article
import com.kotlin.demo.database.LocalRoomRequestManager
import com.kotlin.demo.modules.collect.inter.CollectModule
import com.kotlin.demo.modules.collect.inter.CollectPresenter

class CollectModuleImpl : CollectModule {
    override fun requestInsert(
        listener: CollectPresenter.OnCollectListener,
        vararg article: Article
    ) {
        LocalRoomRequestManager.getInstance().insertArticles(*article)
        // TODO 伪代码：例如：这里还可以做很多的逻辑，等等，最终确保此操作没有问题，就返回true
        listener.showUI(true)
    }

    override fun requestUpdate(
        listener: CollectPresenter.OnCollectListener,
        vararg article: Article
    ) {
        LocalRoomRequestManager.getInstance().updateArticles(*article)
        listener.showUI(true)
    }

    override fun requestDelete(
        listener: CollectPresenter.OnCollectListener,
        vararg article: Article
    ) {
        LocalRoomRequestManager.getInstance().deleteArticles(*article)
        listener.showUI(true)
    }

    override fun requestQuery(
        listener: CollectPresenter.OnCollectListener,
        vararg article: Article
    ) {
        LocalRoomRequestManager.getInstance().queryAllArticle()
        listener.showUI(true)
    }

    override fun requestDeleteAll(listener: CollectPresenter.OnCollectListener) {
        LocalRoomRequestManager.getInstance().deleteAllArticle()
        listener.showUI(true)
    }

    override fun requestQueryAll(listener: CollectPresenter.OnCollectResponseListener) {
        val result = LocalRoomRequestManager.getInstance().queryAllArticle()
        Log.d(Flag.TAG, "requestQueryAll: result$result")
        listener.showResultSuccess(result)
    }
}