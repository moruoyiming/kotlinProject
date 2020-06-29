package com.kotlin.demo.modules.collect

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.demo.R
import com.kotlin.demo.adapter.CollectAdapter
import com.kotlin.demo.base.BaseFragment
import com.kotlin.demo.config.Flag
import com.kotlin.demo.database.Article
import com.kotlin.demo.modules.collect.inter.CollectPresenter
import com.kotlin.demo.modules.collect.inter.CollectView
import kotlinx.android.synthetic.main.fragment_collect.*

class CollectFragment : BaseFragment<CollectPresenter>(), CollectView {


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
        //　TODO Insert　动作
        addData.setOnClickListener {
            val names = arrayOf<String>(
                "乔峰",
                "段誉",
                "虚竹",
                "慕容复",
                "张三",
                "李四",
                "王五",
                "赵六",
                "初七",
                "杜子腾",
                "王小二",
                "李大奇"
            )
            val ages = arrayOf<Int>(
                43,
                24,
                19,
                83,
                64,
                21,
                56,
                32,
                17,
                32,
                45,
                14
            )
            for (index in names.indices) {
                val stu = Article(names[index], names[index])
                presenter.requestInsert(stu)
            }
        }

        // TODO 全部删除动作
        clearData.setOnClickListener {
            presenter.requestDeleteAll()
        }
    }

    override fun createPresenter(): CollectPresenter {
        return CollectPresenterImpl(this)
    }

    override fun recycle() {
        presenter.unAttachView()
    }

    override fun onSuccess(result: List<Article>?) {
        Log.d(Flag.TAG, "showResultSuccess result: ${result.toString()} , LV:${recyclerView} ")

        // 数据 给  recyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = CollectAdapter()
        if (null != result) {
            adapter.allStudents = result
        }
        recyclerView.adapter = adapter
    }

    override fun showResult(result: Boolean) {
        if (result) presenter.requestQueryAll()
    }


}