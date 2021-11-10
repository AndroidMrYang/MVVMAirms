package com.yangk.mvvm.base

import android.app.Application
import android.content.Context

/**
 *   @auther : Yangk
 *   time   : 2021/11/05
 */
open class BaseApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}