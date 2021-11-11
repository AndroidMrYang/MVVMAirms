package com.example.mvvmdemo.vm

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.example.mvvmdemo.entity.ArticlesBean
import com.example.mvvmdemo.entity.NavTypeBean
import com.example.mvvmdemo.http.NetWork
import com.google.android.material.tabs.TabLayout
import com.yangk.mvvm.app.MVVMRFZN
import com.yangk.mvvm.base.BaseViewModel
import com.yangk.mvvm.network.ResponseThrowable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
/**
 *   @author : Yangk
 *   time   : 2021/11/08
 */
class MainViewModel2 : BaseViewModel() {
    /**
     * 网络仓库
     * */
    private val netWork by lazy { NetWork.getInstance() }

    /**
     * 使用了databinding
     * */
    var navTitle = ObservableArrayList<String>()

    var navData = ObservableArrayList<NavTypeBean>()

    var items = MutableLiveData<MutableList<ArticlesBean>>()


    private var page: Int = 0

    var tabOnClickListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            tab?.let {
                getProjectList(navData[it.position].id)
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {
        }

        override fun onTabReselected(tab: TabLayout.Tab?) {

        }

    }

    fun getProjectList(cid: Int) {
        /**
         * 只返回结果，其他全抛自定义异常
         * */
        launchOnlyresult({ netWork.getProjectList(page, cid) }, {
            items.value = it.datas
        }, complete = {

        }, isShowDialog = true)
    }
    /**
     * 先请求tab数据
     * */
    fun getData() {
       launchOnlyresult({
           netWork.getNaviJson()},{
           navData.addAll(it)
           it.forEach { item ->
               navTitle.add(item.name) }
       })
    }
    /**
     * 用Flow流的方式
     * 操作符比较繁琐
     * */
  /*  fun getFirstData() {

        launchUI {
            launchFlow { netWork.getNaviJson() }
                .flatMapConcat {
                    return@flatMapConcat if (it.isSuccess()) {
                        navData.addAll(it.data)

                        it.data.forEach { item -> navTitle.add(item.name) }

                        launchFlow { netWork.getProjectList(page, it.data[0].id) }
                    } else throw ResponseThrowable(it.errorCode, it.errorMsg)
                }
                .onStart { defUI.showDialog.postValue(null) }
                .flowOn(Dispatchers.IO)
                .onCompletion { defUI.dismissDialog.call() }
                .catch {
                    // 错误处理
                    val err = MVVMRFZN.getConfig().globalExceptionHandle(it)
                    LogUtils.d("${err.code}: ${err.errMsg}")
                }
                .collect {
                    if (it.isSuccess()) items.value = it.data.datas
                }
        }
    }*/
}