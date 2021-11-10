package com.example.mvvmdemo

import android.content.Intent
import android.os.Bundle
import com.example.mvvmdemo.databinding.ActivityMain3Binding
import com.example.mvvmdemo.entity.ArticlesBean
import com.example.mvvmdemo.vm.MainViewModel3
import com.yangk.mvvm.base.BaseActivity
import com.yangk.mvvm.event.Message

/**
 *   @auther : Yangk
 *   time   : 2021/11/08
 *  使用Databinging,结合bindingcollectionadapter
 */
class MainActivity3 : BaseActivity<MainViewModel3, ActivityMain3Binding>() {

    override fun layoutId(): Int {
        return R.layout.activity_main3
    }

    override fun initView(savedInstanceState: Bundle?) {
        mBinding.viewModel = viewModel
    }

    override fun initData() {
        viewModel.run {
            getProjectList()
        }
    }

    /**
     * 接收消息
     * */
    override fun handleEvent(msg: Message) {
        when (msg.code) {
            0 -> {
                val bean = msg.obj as ArticlesBean
                // ToastUtils.showShort(bean.title)
                startActivity(Intent(this@MainActivity3,LoginActivity::class.java))
            }
        }
    }
}