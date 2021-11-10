package com.yangk.mvvm.app

import androidx.lifecycle.ViewModelProvider
import com.yangk.mvvm.base.ViewModelFactory
import com.yangk.mvvm.network.ExceptionHandle

/**
 *   @auther : Yangk
 *   time   : 2021/11/05
 */
interface GlobalConfig {

    fun viewModelFactory(): ViewModelProvider.Factory? = ViewModelFactory.getInstance()

    fun globalExceptionHandle(e: Throwable) = ExceptionHandle.handleException(e)

}