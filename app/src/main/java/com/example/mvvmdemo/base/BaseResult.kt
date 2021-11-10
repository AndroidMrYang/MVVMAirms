package com.example.mvvmdemo.base

import com.yangk.mvvm.base.IBaseResponse

/**
 *   @auther : Yangk
 *   time   : 2021/11/05
 */
data class BaseResult<T>(
    val errorMsg: String,
    val errorCode: Int,
    val data: T
) : IBaseResponse<T> {

    override fun code() = errorCode

    override fun msg() = errorMsg

    override fun data() = data

    override fun isSuccess() = errorCode == 0

}