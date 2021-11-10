package com.example.mvvmdemo.vm

import androidx.databinding.ObservableArrayList
import com.example.mvvmdemo.BR

import com.example.mvvmdemo.R
import com.example.mvvmdemo.entity.ArticlesBean
import com.example.mvvmdemo.http.NetWork
import com.yangk.mvvm.base.BaseViewModel
import com.yangk.mvvm.event.Message
import me.tatarka.bindingcollectionadapter2.ItemBinding
/**
 *   @author : Yangk
 *   time   : 2021/11/08
 */
class MainViewModel3 : BaseViewModel() {
    /**
     * 网络仓库
     * */
    private val netWork by lazy { NetWork.getInstance() }
    /**
     * livedata 发送消息到当前activity
    * */
    private val itemOnClickListener = object : OnItemClickListener {
        override fun onItemClick(item: ArticlesBean) {
            //livedata 发送消息到当前activity

           defUI.msgEvent.postValue(Message(0, obj = item))
          //  defUI.toastEvent.postValue(item.title)

        }

    }
    /**
     * 绑定的adapter数据源
     * */
    var items = ObservableArrayList<ArticlesBean>()

    /**
     * ItemBinding不需要写adapter
     * */
    var itemBinding = ItemBinding.of<ArticlesBean>(BR.itemBean, R.layout.item_project_list)
        .bindExtra(BR.listenner, itemOnClickListener)

    private var page: Int = 0

    fun getProjectList() {
        launchOnlyresult({ netWork.getProjectList(page, 293) }, {
            items.clear()
            items.addAll(it.datas)
        })
    }

    interface OnItemClickListener {
        fun onItemClick(item: ArticlesBean)
    }
}