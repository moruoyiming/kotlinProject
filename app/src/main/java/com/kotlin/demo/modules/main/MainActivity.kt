package com.kotlin.demo.modules.main

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kotlin.demo.R
import com.kotlin.demo.base.BaseActivity
import com.kotlin.demo.modules.main.inter.MainPresenter
import com.kotlin.demo.modules.main.inter.MainView

class MainActivity : BaseActivity<MainPresenter>(), MainView {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_collect,
            R.id.navigation_personal
        ).build()

        val navController: NavController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenterImpl(this);
    }

    override fun recycle() {
    }
}