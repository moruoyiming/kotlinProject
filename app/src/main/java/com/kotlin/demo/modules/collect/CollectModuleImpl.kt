package com.kotlin.demo.modules.collect

import com.kotlin.demo.database.Article
import com.kotlin.demo.modules.collect.inter.CollectModule
import com.kotlin.demo.modules.collect.inter.CollectPresenter

class CollectModuleImpl : CollectModule {
    override fun requestInsert(
        listener: CollectPresenter.OnCollectListener,
        vararg article: Article
    ) {

    }

    override fun requestUpdate(
        listener: CollectPresenter.OnCollectListener,
        vararg article: Article
    ) {

    }

    override fun requestDelete(
        listener: CollectPresenter.OnCollectListener,
        vararg article: Article
    ) {

    }

    override fun requestQuery(
        listener: CollectPresenter.OnCollectListener,
        vararg article: Article
    ) {

    }

    override fun requestDeleteAll() {

    }

    override fun requestQueryAll() {

    }
}