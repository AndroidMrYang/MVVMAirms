package com.example.mvvmdemo.impl

import coil.load
import com.example.mvvmdemo.entity.BannerBean
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder

/**
 *   @author : Yangk
 *   time   : 2020/09/05
 */
class GlideImageLoader : BannerImageAdapter<BannerBean>(null) {

    override fun onBindView(
        holder: BannerImageHolder?,
        data: BannerBean?,
        position: Int,
        size: Int
    ) {
        holder?.imageView?.load(data?.imagePath)
    }

}