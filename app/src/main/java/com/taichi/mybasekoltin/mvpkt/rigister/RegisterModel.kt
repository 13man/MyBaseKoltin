package com.taichi.mybasekoltin.mvpkt.rigister

import android.content.Context

interface RegisterModel {

    fun cancelRequest() {

    }

    fun register(
        context: Context,
        username: String,
        password: String,
        repassword: String,
        // 把结果 给 P层  接口回调
        listener: RegisterPresenter.OnRegisterListener
    )
}