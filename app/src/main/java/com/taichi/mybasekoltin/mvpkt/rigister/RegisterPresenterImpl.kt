package com.taichi.mybasekoltin.mvpkt.rigister

import android.content.Context
import com.taichi.mybasekoltin.entity.LoginRegisterResponse

/**
 * 工作，中转，校验     //公开的构造方法
 */
class RegisterPresenterImpl constructor(var view: RegisterView?) : RegisterPresenter
    , RegisterPresenter.OnRegisterListener {

    //需要M 去请求服务器拿业务数据
    private val model = RegisterModelImpl()


    override fun registerWanAndroid(
        context: Context,
        username: String,
        password: String,
        repassword: String
    ) {
        // TODO
        // 可以做很多的事情

        // 很多的校验

        model.register(context, username, password, repassword, this)
    }

    override fun attachView() {

    }

    override fun unAttachView() {
        view = null
        model.cancelRequest()
    }

    override fun RegisterSucc(registerBean: LoginRegisterResponse?) {
        view?.RegisterSucc(registerBean)
    }

    override fun RegisterError(errorMsg: String?) {
        view?.RegisterError(errorMsg)
    }
}