package com.kotlin.demo.modules.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.kotlin.demo.R
import com.kotlin.demo.adapter.HomeInfoListAdapter
import com.kotlin.demo.beans.HomeDataResponse
import com.kotlin.demo.config.Flag
import com.kotlin.demo.modules.webview.DetailLinkActivity
import com.kotlin.demo.network.NetWorkResultData
import com.kotlin.demo.network.RequestApi
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.Response

class HomeFragment : Fragment() {

    private lateinit var linkPath1 :String
    private lateinit var linkPath2 :String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestHomeData()
        iv_top.setOnClickListener{
            val intent: Intent = Intent(activity, DetailLinkActivity::class.java)
            intent.putExtra(Flag.URL_KEY,linkPath1)
            startActivity(intent)
        }
        iv_bottom.setOnClickListener {
            val intent: Intent = Intent(activity, DetailLinkActivity::class.java)
            intent.putExtra(Flag.URL_KEY,linkPath2)
            startActivity(intent)
        }
    }

    private fun requestHomeData() {
        RequestApi.instanceRequestAction(Flag.SERVER_URL, "1", object : NetWorkResultData() {

            // 失败 main 已经NetworkResultData切换过来了
            override fun requestError(info: String) {
                Log.e(Flag.TAG, "requestHomeData requestError info:$info")
                showResultError(info)
            }

            // 成功 main 已经NetworkResultData切换过来了
            override fun requestSuccess(result: Response) {
                // gons   json  ---> bean
                try {
                    val resultData = result.body()?.string().toString()
                    Log.e(Flag.TAG,
                        "成功  数据在response里面  获取后台给我们的JSON 字符串 resultData:$resultData")

                    // Gson解析成可操作的对象
                    val gson = Gson()
                    val homeDataResponse: HomeDataResponse = gson.fromJson(resultData, HomeDataResponse::class.java)
                    showResultSuccess(homeDataResponse)
                }catch (e: Exception) {
                    e.printStackTrace()

                    Log.e(Flag.TAG, "requestSuccess 解析数据时Exception:${e.message}")
                }
            }

        })
    }

    /**
     * TODO 首页的画面展示【成功】
     */
    private fun showResultSuccess(result: HomeDataResponse) {
        text_home.text = "欢迎同学们的到来>>>>>>>>>>>"

        // home_listview.adapter = HomeInfoListAdapter(context!!, result.data.news_list)
        home_listview.adapter = context?.myRun { HomeInfoListAdapter(it, result.data.news_list) }

        // 两张图片的显示
        Glide.with(iv_top).load(result.data.company_list[0].image).into(iv_top)
        Glide.with(iv_bottom).load(result.data.ad_list[0].image).into(iv_bottom)

        //webview
        linkPath1 = result.data.ad_list[0].link;
        linkPath2 = result.data.company_list[0].link;
    }

    /**
     * TODO 首页的画面展示【失败】
     */
    private fun showResultError(errorMsg: String) {
        Toast.makeText(activity, "首页数据请求失败: errorMsg:$errorMsg", Toast.LENGTH_SHORT).show()
    }
}

fun <T, R> T.myRun(m: (T) -> R) : R  = m(this)  // 调用高阶函数