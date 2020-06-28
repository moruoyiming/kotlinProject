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

    private lateinit var mActivity: AppCompatActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //java mActivity = (AppCompatActivity)context
        //kt context as AppCompatActivity
        mActivity = context as AppCompatActivity
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
        initView()
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