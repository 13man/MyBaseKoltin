package com.taichi.mybasekoltin.mvpkt.rigister

import com.taichi.mybasekoltin.entity.LoginRegisterResponse

interface RegisterView {
    fun RegisterSucc(registerBean: LoginRegisterResponse?)

    fun RegisterError(errorMsg: String?);

}