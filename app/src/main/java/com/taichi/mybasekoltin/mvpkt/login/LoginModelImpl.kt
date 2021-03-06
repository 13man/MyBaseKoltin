package com.taichi.mybasekoltin.mvpkt.login

import android.content.Context
import android.util.Log
import com.taichi.mybasekoltin.api.WanAndroidAPI
import com.taichi.mybasekoltin.entity.LoginRegisterResponse
import com.taichi.mybasekoltin.net.APIClient
import com.taichi.mybasekoltin.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginModelImpl : LoginModel {

    private var mCompositeDisposable: CompositeDisposable? = null
    override fun login(
        context: Context,
        username: String,
        password: String,
        onLoginListener: LoginPresenter.OnLoginListener?
    ) {
        mCompositeDisposable = CompositeDisposable()
        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            .loginAction(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APIResponse<LoginRegisterResponse>(context) {
                override fun success(data: LoginRegisterResponse?) {
                    Log.e("LoginModelImpl", "success: $data")
                    onLoginListener?.loginSuccess(data)
                }

                override fun failure(errorMsg: String?) {
                    onLoginListener?.loginFialure(errorMsg)
                }

                override fun onSubscribePre(d: Disposable) {
                    mCompositeDisposable?.add(d)
                }

            })
    }

    override fun cancelRequest() {
        //取消请求，取消订阅
        mCompositeDisposable?.clear()
        mCompositeDisposable = null
    }

}