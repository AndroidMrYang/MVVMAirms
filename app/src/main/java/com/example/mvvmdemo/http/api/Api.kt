package com.example.mvvmdemo.http.api

import com.example.mvvmdemo.base.BaseResult
import com.example.mvvmdemo.entity.BannerBean
import com.example.mvvmdemo.entity.HomeListBean
import com.example.mvvmdemo.entity.NavTypeBean
import com.example.mvvmdemo.entity.UsedWeb
import retrofit2.http.*

interface Api {

    /**
     * 玩安卓轮播图
     */
    @GET("banner/json")
    suspend fun getBanner(): BaseResult<List<BannerBean>>


    /**
     * 导航数据
     */
    @GET("project/tree/json")
    suspend fun naviJson(): BaseResult<List<NavTypeBean>>


    /**
     * 项目列表
     * @param page 页码，从0开始
     */
    @GET("article/listproject/{page}/json")
    suspend fun getHomeList(@Path("page") page: Int): BaseResult<HomeListBean>


    /**
     * 项目列表
     * @param page 页码，从0开始
     */
    @GET("project/list/{page}/json")
    suspend fun getProjectList(@Path("page") page: Int, @Query("cid") cid: Int): BaseResult<HomeListBean>


    /**
     * 常用网站
     */
    @GET("friend/json")
    suspend fun getPopularWeb(): BaseResult<MutableList<UsedWeb>>
    /**
     * 登录
     */
    @POST("user/login")
    @FormUrlEncoded
    suspend fun login(@Field("username") phoneNumber: String, @Field("password") password: String): BaseResult<Any>
}