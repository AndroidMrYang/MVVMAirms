package com.yangk.mvvm.binding.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

/**
 *   @auther : Yangk
 *   time   : 2021/11/05
 */
object ImageAdapter {

    @BindingAdapter(value = ["url", "placeholder"], requireAll = false)
    @JvmStatic
    fun setImageUrl(imageView: ImageView, url: String, placeholder: Int) {
        imageView.load(url) {
            placeholder(placeholder)
        }
    }

}