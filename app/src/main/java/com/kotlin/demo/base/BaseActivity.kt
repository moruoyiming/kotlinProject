package com.kotlin.demo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter {//, P : Serializable

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        presenter = createPresenter()
    }

    abstract fun createPresenter(): P

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun recycle()

    override fun onDestroy() {
        super.onDestroy()
        presenter.unAttachView()
        recycle()
    }
}