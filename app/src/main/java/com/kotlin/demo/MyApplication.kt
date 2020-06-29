package com.kotlin.demo

import android.app.Application
import com.kotlin.demo.database.ArticleDatabase

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ArticleDatabase.getDatabase(this)
    }
}