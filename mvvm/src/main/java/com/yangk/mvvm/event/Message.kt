package com.yangk.mvvm.event

/**
 *   @auther : Yangk
 *   time   : 2021/11/05
 */
class Message @JvmOverloads constructor(
    var code: Int = 0,
    var msg: String = "",
    var arg1: Int = 0,
    var arg2: Int = 0,
    var obj: Any? = null
)