package com.yangk.mvvm.base

/**
 *   @auther : Yangk
 *   time   : 2020/01/13
 *   根据项目不同返回规则不同配置接收返回的BaseBean  需实现IBaseResponse  例:BaseResult
 */
interface IBaseResponse<T> {
    fun code(): Int
    fun msg(): String
    fun data(): T
    fun isSuccess(): Boolean
}