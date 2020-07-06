package com.taichi.mybasekoltin.mvpkt.login

import android.content.Context
import com.taichi.mybasekoltin.entity.LoginRegisterResponse
import com.taichi.mybasekoltin.mvpkt.base.IBasePresenter

//Presenter层
interface LoginPresenter:IBasePresenter{
    //登录动作
    fun loginAction(context: Context, userName: String, passWord: String)

// M --->P 回调数据
    interface OnLoginListener {
        fun loginSuccess(loginBean: LoginRegisterResponse?)

        fun loginFialure(errorMsg: String?)
    }
}