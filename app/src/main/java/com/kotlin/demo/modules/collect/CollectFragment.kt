package com.kotlin.demo.modules.collect

import android.widget.Toast
import com.kotlin.demo.R
import com.kotlin.demo.base.BaseFragment
import com.kotlin.demo.database.Article
import com.kotlin.demo.modules.collect.inter.CollectPresenter
import com.kotlin.demo.modules.collect.inter.CollectView

class CollectFragment : BaseFragment<CollectPresenter>() ,CollectView {


    override fun getLayoutId(): Int {
        Toast.makeText(activity, "收藏", Toast.LENGTH_LONG).show()
        return R.layout.fragment_collect
    }

    // 构造代码块
    init {
        setHasOptionsMenu(true)
    }

    override fun initView() {
        presenter.requestQueryAll()
    }

    override fun createPresenter(): CollectPresenter {
        return CollectPresenterImpl(this)
    }

    override fun recycle() {
        presenter.unAttachView()
    }

    override fun onSuccess(result: List<Article>?) {
        TODO("Not yet implemented")
    }

    override fun onError(code: Int, msg: String?) {
        TODO("Not yet implemented")
    }
}