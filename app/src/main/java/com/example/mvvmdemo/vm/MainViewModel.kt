package com.example.mvvmdemo.vm

import androidx.lifecycle.MutableLiveData
import com.yangk.mvvm.base.BaseViewModel
import com.example.mvvmdemo.base.BaseResult
import com.example.mvvmdemo.entity.BannerBean
import com.example.mvvmdemo.entity.HomeListBean
import com.example.mvvmdemo.http.NetWork
/**
 *   @author : Yangk
 *   time   : 2021/11/06
 */
class MainViewModel : BaseViewModel() {
    /**
     * 网络仓库
     * */
    private val netWork by lazy { NetWork.getInstance() }
    /**
     * adapter数据源
     * */
    private var projectData = MutableLiveData<BaseResult<HomeListBean>>()
    /**
     *Banner数据源
     * */
    private var mBanners = MutableLiveData<List<BannerBean>>()

    fun getBanner(): MutableLiveData<List<BannerBean>> {
     /*   launchGo( {
            mBanners.value = netWork.getBannerData().
        })*/
        /**
         * 过滤网络请求,返回List<BannerBean>  详看launchOnlyresult
         * */
        launchOnlyresult({
                 netWork.getBannerData()
            }
            ,{
                mBanners.value = it
            })
        return mBanners
    }

    /**
     * @param page 页码
     * @param refresh 是否刷新
     */
    fun getHomeList(
        page: Int,
    ): MutableLiveData<BaseResult<HomeListBean>> {
        /**
         * 不过滤网络请求,返回BaseResult<HomeListBean>  详看launchGo
         * */
        launchGo({
            projectData.value = netWork.getHomeList(page)
        }, {
            projectData.value = null
        })
        return projectData
    }
}