package com.kotlin.demo.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseFragment<P> : Fragment() where P : IBasePresenter {
    lateinit var presenter: P

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = createPresenter()
    }


    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun createPresenter(): P

    abstract fun recycle()

    override fun onDestroy() {
        super.onDestroy()
        presenter.unAttachView()
        recycle()
    }
}