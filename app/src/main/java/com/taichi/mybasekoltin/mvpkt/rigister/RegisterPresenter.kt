package com.taichi.mybasekoltin.mvpkt.rigister

import android.content.Context
import com.taichi.mybasekoltin.entity.LoginRegisterResponse
import com.taichi.mybasekoltin.mvpkt.base.IBasePresenter

interface RegisterPresenter : IBasePresenter {

    fun registerWanAndroid(
        context: Context, username: String,
        password: String, repassword: String
    )

    interface OnRegisterListener {
        fun RegisterSucc(registerBean: LoginRegisterResponse?)
        fun RegisterError(errorMsg: String?);
    }
}