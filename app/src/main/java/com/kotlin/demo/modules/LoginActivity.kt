package com.kotlin.demo.modules

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.demo.R
import com.kotlin.demo.api.WanAndroidApi
import com.kotlin.demo.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

/**
 * <pre>
 *     author: jian
 *     Date  : 2020/6/18 8:21 PM
 *     Description:
 * </pre>
 */
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        user_login_bg.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { view ->
        //id  内部根据 = 知道是要setId  否则  getId
        when (view.id) {
            R.id.user_login_bg -> {
                val userName = user_phone_et.text.toString()
                val userPwd = user_password_et.text.toString()
                Log.d("TAG", "userName:$userName ,userPwd: $userPwd")
                ApiClient.instance.instanceRetrofit(WanAndroidApi::class.java)
                    .loginAction(userName, userPwd)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()

            }

        }

    }
}