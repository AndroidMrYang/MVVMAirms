package com.example.mvvmdemo.vm

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.yangk.mvvm.base.BaseViewModel
import com.example.mvvmdemo.entity.UserInfo
import com.example.mvvmdemo.http.NetWork
import com.yangk.mvvm.core.binding.observable.StringObservableField

/**
 *   @author : Yangk
 *   time   : 2021/11/06
 *   登录vm
 *   注意 @={}   @{}    variable view 才能使用veiw的api
 */
class LoginViewModel : BaseViewModel() {
    /**
     * 网络仓库
     * */
    private val netWork by lazy { NetWork.getInstance() }
    /**
     *用户名
     * */
    val userName = StringObservableField()
    /**
     *密码
     * */
    var password = StringObservableField()
    //为了取值方便封装ObservableField
   // var password = ObservableField<String>()
    /**
     * 是否显示明文密码
     * */
    var isShowPwd = ObservableBoolean()

    /**
     *
     * 登录信息
     * */
    var loginData = MutableLiveData<UserInfo>()


    /**
     * 登录
     * @param phoneNumber String
     * @param password String
     */
    fun login(phoneNumber: String, password: String) {
        launchOnlyresult({
            netWork.login(phoneNumber,password)
        },success= {


        },error ={
           // defUI.toastEvent.postValue("${it.errMsg}")
            defUI.toastEvent.postValue("登录成功")
        },isShowDialog =  true)

    }

}