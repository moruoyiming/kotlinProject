package com.kotlin.demo.modules.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kotlin.demo.R
import com.kotlin.demo.config.Flag
import com.kotlin.demo.network.NetWorkResultData
import com.kotlin.demo.network.RequestApi
import okhttp3.Response

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        RequestApi.instanceRequestAction(Flag.SERVER_URL,"1",object :NetWorkResultData(){
            override fun requestError(info: String) {
            }

            override fun requestSuccess(result: Response) {
            }

        })
    }
}