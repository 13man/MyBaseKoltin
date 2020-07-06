package com.taichi.mybasekoltin.mvpkt.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

//Base类面向抽象，不面向细节
abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter {
    lateinit var persenter: P  //超类不管什么具体类型，也不知道，用泛型代替

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //面向抽象，不面向细节
        persenter = createP()
        setContentView(getLayoutID())
        initListener()
        initData()
    }

    abstract fun createP(): P
    abstract fun initListener()
    abstract fun initData()

    @LayoutRes
    abstract fun getLayoutID(): Int

    abstract fun recycle()

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }
}