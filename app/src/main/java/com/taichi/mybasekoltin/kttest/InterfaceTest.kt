package com.taichi.mybasekoltin.kttest

interface InterfaceTest {
    var count: Int
    fun plus(num: Int) {
        count += num
    }

}

//实现该接口
class Impl : InterfaceTest {

    override var count: Int = 0

    override fun plus(num: Int) {
        super.plus(num)
    }
}