package com.kotlin.demo.modules.collect.inter

import com.kotlin.demo.database.Article

interface CollectModule {

    fun requestInsert(listener: CollectPresenter.OnCollectListener, vararg article: Article);

    fun requestUpdate(listener: CollectPresenter.OnCollectListener, vararg article: Article);

    fun requestDelete(listener: CollectPresenter.OnCollectListener, vararg article: Article);

    fun requestQuery(listener: CollectPresenter.OnCollectListener, vararg article: Article);

    fun requestDeleteAll();

    fun requestQueryAll();
}