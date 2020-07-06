package com.taichi.mybasekoltin.mvpkt.login

import com.taichi.mybasekoltin.entity.LoginRegisterResponse

//View层 ，把结果显示到 Activity /Fragment 中

interface LoginView {

    fun loginSuccess(loginBean: LoginRegisterResponse?)

    fun loginFialure(errorMsg: String?)
}