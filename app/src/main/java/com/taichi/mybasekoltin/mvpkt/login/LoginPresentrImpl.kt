package com.taichi.mybasekoltin.mvpkt.login

import android.content.Context
import com.taichi.mybasekoltin.entity.LoginRegisterResponse

//工作，中转，校验     //公开的构造方法
class LoginPresentrImpl(var loginView: LoginView ?) : LoginPresenter,
    LoginPresenter.OnLoginListener {

    //需要M去请求服务器  ，需要view更新Activity,Fragment

    private val loginModel: LoginModel = LoginModelImpl()


    override fun loginAction(context: Context, userName: String, passWord: String) {
        // ....省略一些校验

        //m层去请求服务器
        loginModel.login(context, userName, passWord, this)
    }

    //BasePresenter
    override fun attachView() {
        TODO("Not yet implemented")
    }

    //什么时候被调用，View视图层
    override fun unAttachView() {
        loginView = null
        loginModel.cancelRequest()
    }


    //接受模型层数据 回调过来，在给到view层去更新ui

    override fun loginSuccess(loginBean: LoginRegisterResponse?) {
        loginView?.loginSuccess(loginBean)
    }

    override fun loginFialure(errorMsg: String?) {
        loginView?.loginFialure(errorMsg)
    }


}