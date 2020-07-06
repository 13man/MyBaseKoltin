package com.taichi.mybasekoltin.mvpkt.login

import android.content.Context

//Model层（模型层）  把结果给到P层， 通过接口回调
interface LoginModel {

    //取消请求
    fun cancelRequest()

    //登录
    fun login(
        context: Context,
        username: String,
        password: String,
        //把结果给到P层，通过接口回调
        onLoginListener: LoginPresenter.OnLoginListener?
    )


}