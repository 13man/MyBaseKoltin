package com.taichi.mybasekoltin.kttest

class OuterClass {
    var type: Int = 0

    //可以认为是嵌套类
    class InnerStaticClass() {
        //    var   innerType :Int = type
    }

    //这才是内部类  用inner  关键字
    inner class InnerClass() {
        var innerType: Int = type
    }
  //伴生对象 ，伴生体里放静态 常量，静态变量，静态方法
    companion object {
        //私有常量
        val type1: Int = 1;

        //公有常量
        const val type2: Int = 2;

        //私有静态变量
        var type3: Int = 3;

        fun run() {
            println("run ... ")
        }
    }

}