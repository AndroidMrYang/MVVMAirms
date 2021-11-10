package com.example.mvvmdemo.http

import com.example.mvvmdemo.http.api.Api

class NetWork {

    private val mService by lazy { RetrofitClient.getInstance().create(Api::class.java) }

    suspend fun getBannerData() = mService.getBanner()

    suspend fun getHomeList(page: Int) = mService.getHomeList(page)

    suspend fun getNaviJson() = mService.naviJson()

    suspend fun getProjectList(page: Int, cid: Int) = mService.getProjectList(page, cid)

    suspend fun getPopularWeb() = mService.getPopularWeb()

    suspend  fun login(phoneNumber: String, password: String) =mService.login(phoneNumber,password)



    companion object {
        @Volatile
        private var netWork: NetWork? = null

        fun getInstance() = netWork ?: synchronized(this) {
            netWork ?: NetWork().also { netWork = it }
        }
    }

}