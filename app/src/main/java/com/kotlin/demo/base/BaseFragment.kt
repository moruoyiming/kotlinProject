package com.kotlin.demo.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kotlin.demo.config.Flag

abstract class BaseFragment<P> : Fragment() where P : IBasePresenter {

    private val TAG: String = "BaseFragment"

    lateinit var presenter: P

    private lateinit var mActivity: AppCompatActivity


    override fun onAttach(context: Context) {
        super.onAttach(context)
        //java mActivity = (AppCompatActivity)context
        //kt context as AppCompatActivity
        Log.i(TAG, "onAttach")
        mActivity = context as AppCompatActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        presenter = createPresenter()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView")
        val root: View? = inflater.inflate(getLayoutId(), container, false)
        return root ?:   /* root null  就用后面的 */    super.onCreateView(
            inflater,
            container,
            savedInstanceState
        )
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i(TAG, "onActivityCreated")
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