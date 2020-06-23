package com.kotlin.demo.modules.main

import com.kotlin.demo.modules.main.inter.MainPresenter
import com.kotlin.demo.modules.main.inter.MainView

class MainPresenterImpl(private var mainview: MainView?): MainPresenter {
}