package com.example.mvvmdemo.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ItemUsedwebBinding
import com.example.mvvmdemo.entity.ArticlesBean

/**
 *   @auther : yangK
 *   time   : 2020/11/14
 */

class MeWebAdapter :
    BaseQuickAdapter<ArticlesBean, BaseDataBindingHolder<ItemUsedwebBinding>>(R.layout.item_usedweb) {

    override fun convert(holder: BaseDataBindingHolder<ItemUsedwebBinding>, item: ArticlesBean) {
        holder.dataBinding?.itemData = item
        holder.dataBinding?.executePendingBindings()
    }

}