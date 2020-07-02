package com.kotlin.demo.modules.webview

import android.os.Bundle
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.demo.R
import com.kotlin.demo.config.Flag
import kotlinx.android.synthetic.main.activity_detail_link.*

class DetailLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_link)
        supportActionBar?.hide()
        val mUrl: String = intent.getStringExtra(Flag.URL_KEY)
        val mWebSetting : WebSettings = web_view.settings
        mWebSetting.useWideViewPort = false //将图片调整到适合webview 的大小
        mWebSetting.javaScriptEnabled = true //支持js
        mWebSetting.loadsImagesAutomatically = true //支持自动加载图片

        web_view.loadUrl(mUrl)
    }

}