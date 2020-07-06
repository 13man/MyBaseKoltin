package com.taichi.mybasekoltin.mvpkt.rigister

import android.content.Context
import com.taichi.mybasekoltin.api.WanAndroidAPI
import com.taichi.mybasekoltin.entity.LoginRegisterResponse
import com.taichi.mybasekoltin.net.APIClient
import com.taichi.mybasekoltin.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RegisterModelImpl : RegisterModel {
    private var mCompositeDisposable: CompositeDisposable? = null
    override fun register(
        context: Context,
        username: String,
        password: String,
        repassword: String,
        listener: RegisterPresenter.OnRegisterListener
    ) {
        mCompositeDisposable = CompositeDisposable()
        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            .registerAction(username, password, repassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APIResponse<LoginRegisterResponse>(context) {
                override fun success(data: LoginRegisterResponse?) {
                    listener.RegisterSucc(data)
                }

                override fun failure(errorMsg: String?) {
                    listener.RegisterError(errorMsg)
                }

                override fun onSubscribePre(d: Disposable) {
                    mCompositeDisposable?.add(d)
                }

            })
    }

    override fun cancelRequest() {
        super.cancelRequest()
        mCompositeDisposable?.clear()
        mCompositeDisposable = null
    }
}