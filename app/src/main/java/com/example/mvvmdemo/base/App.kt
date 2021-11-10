package com.example.mvvmdemo.base

import com.yangk.mvvm.app.GlobalConfig
import com.yangk.mvvm.app.MVVMRFZN
import com.yangk.mvvm.base.BaseApplication
import com.yangk.mvvm.base.ViewModelFactory
import com.blankj.utilcode.util.LogUtils
import com.example.mvvmdemo.BuildConfig
import com.squareup.leakcanary.LeakCanary

class App : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        // 在OnCreate 中可以传入 自定义的 GlobalConfig
        MVVMRFZN.install(object : GlobalConfig {
            override fun viewModelFactory() = ViewModelFactory.getInstance()
        })


        //内存泄漏检测
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this)
        }

        LogUtils.getConfig().run {
            isLogSwitch = BuildConfig.DEBUG
            setSingleTagSwitch(true)

        }
    }
}