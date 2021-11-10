package com.example.mvvmdemo

import android.os.Bundle
import android.widget.CompoundButton
import com.example.mvvmdemo.databinding.ActivityLoginBinding
import com.example.mvvmdemo.vm.LoginViewModel
import com.yangk.mvvm.base.BaseActivity
import com.yangk.mvvm.ext.showDialogMessage

/**
 *       登录页面
 *      使用databinding
 * */
class LoginActivity : BaseActivity<LoginViewModel,ActivityLoginBinding>() {


    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView(savedInstanceState: Bundle?) {
        /**
         * databinding初始化
         * */
        mBinding.viewModel=viewModel
        mBinding.click=LoginClickProxy()
    }

    override fun initData() {

    }

    inner class LoginClickProxy {
        /**
         *
         * 清除数据
         * */
        fun clear() {
            viewModel.userName.set("")
        }

        /**
         * 查看密码监听
         * */
        var onCheckedChangeListener =
            CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                viewModel.isShowPwd.set(isChecked)
            }

        /**
         * 登录
         * */
        fun login() {

            when {
                viewModel.userName.get().isEmpty()  -> showDialogMessage("手机号不能为空")
                viewModel.password.get().isEmpty()  -> showDialogMessage("密码不能为空")
                else -> viewModel.login(
                    viewModel.userName.get().toString(),
                    viewModel.password.get().toString()
                )
            }
        }


    }
}