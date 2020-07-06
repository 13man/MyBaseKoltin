package com.taichi.mybasekoltin.mvpkt.base

/**
 * 所有p层的超父类， 最上层标准
 */
interface IBasePresenter {

    //粘住
    fun attachView()

    //离开  view(视图层 Activity,Fragment)onDestory()
    fun unAttachView()

}