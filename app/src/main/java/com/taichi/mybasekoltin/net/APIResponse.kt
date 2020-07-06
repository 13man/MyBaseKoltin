package com.taichi.mybasekoltin.net

import android.content.Context
import com.taichi.mybasekoltin.entity.LoginRegisterResponseWrapper
import com.taichi.mybasekoltin.utils.LoadingDialog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

//RxJava 自定义操作符  脱皮，只要包装类里面的data  和msg
abstract class APIResponse<T>(val context: Context) : Observer<LoginRegisterResponseWrapper<T>> {

    //成功
    abstract fun success(data: T?)

    //失败
    abstract fun failure(errorMsg: String?)

    abstract fun  onSubscribePre(d: Disposable)

    //起点分发的时候
    override fun onSubscribe(d: Disposable) {
        LoadingDialog.show(context)
        onSubscribePre(d)
    }

    override fun onNext(t: LoginRegisterResponseWrapper<T>) {
      if (t.data==null){
          //失败
          failure("登录失败了，请检查原因：${t.errorMsg}")
      }else{
          //成功
          success(t.data)
      }
    }

    //上流流下了的错误
    override fun onError(e: Throwable) {
        LoadingDialog.cancel()
        failure(e.message)
    }

    //完成
    override fun onComplete() {
        LoadingDialog.cancel()
    }
}