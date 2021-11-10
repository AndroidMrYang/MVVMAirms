package com.example.mvvmdemo

import android.content.Intent
import android.os.Bundle
import com.yangk.mvvm.base.BaseActivity
import com.example.mvvmdemo.adapter.MeWebAdapter
import com.example.mvvmdemo.databinding.ActivityMain2Binding
import com.example.mvvmdemo.vm.MainViewModel2

/**
 *   @auther : Yangk
 *   time   : 2021/11/08
 *  使用Databinging,结合BRVAH
 */
class MainActivity2 : BaseActivity<MainViewModel2, ActivityMain2Binding>() {


    private val mAdapter by lazy { MeWebAdapter() }
    /**
     * 使用Databinging时  需要返回layoutId   不适用不需要返回
     * */
    override fun layoutId(): Int {
        return R.layout.activity_main2
    }

    override fun initView(savedInstanceState: Bundle?) {
       mBinding.viewModel = viewModel
        mAdapter.apply {
            setOnItemClickListener { adapter, view, position ->
                startActivity(Intent(this@MainActivity2, MainActivity3::class.java))
            }
        }
    }

    override fun initData() {
        with(mBinding.rvProject) {
            adapter = mAdapter
        }

        viewModel.items.observe(this@MainActivity2, {
            mAdapter.setNewInstance(it)
        })
        viewModel.getData()
        //viewModel.getFirstData()
    }
}