package com.yangk.mvvm.app

/**
 *   @auther : Yangk
 *   time   : 2021/11/05
 */
object MVVMRFZN {

    private val DEFULT = object : GlobalConfig {}

    private var mConfig: GlobalConfig = DEFULT

    fun install(config: GlobalConfig) {
        mConfig = config
    }

    fun getConfig() = mConfig

}