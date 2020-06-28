package com.kotlin.demo.modules.collect.inter

import com.kotlin.demo.database.Article

interface CollectView {
    fun onSuccess(result: List<Article>?)

    fun onError(code: Int, msg: String?)
}