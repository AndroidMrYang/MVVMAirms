package com.yangk.mvvm.binding.observable

import androidx.databinding.ObservableField

/**
 * 作者　: yangK
 * 时间　: 2020/12/17
 * 描述　:自定义的Int类型 ObservableField  提供了默认值，避免取值的时候还要判空
 */
class DoubleObservableField(value: Double = 0.0) : ObservableField<Double>(value) {

    override fun get(): Double {
        return super.get()!!
    }

}