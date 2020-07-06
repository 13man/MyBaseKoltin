package com.taichi.mybasekoltin.kttest

import android.util.Log

class ClassA {

    var str: String = ""

    fun main(args: Array<String>) {
        str = "Hello Word"
        print(str)
    }


    val intArray: IntArray = intArrayOf(1, 2, 3, 4)
    val sArray: Array<String> = Array(3) { i -> i.toString() }
    val anyArray: Array<Any> = arrayOf(1, "1111", 4.1f)
    val Array: LongArray = longArrayOf(1L, 2L, 3L)

    fun sum(a: Int, b: Int): Int {
        return a + b;
    }

    //Koltin 表达式 ，编译器可以自行推断出返回类型
    fun sum1(a: Int, b: Int) = a + b;

    //创建一个函数获取两个数的最大值
    fun max1(a: Int, b: Int) = if (a > b) a else b

    fun max2(a: Int, b: Int) = if (a > b) {
        println(a)
        a
    } else {
        println(b)
        b
    }


    fun printInt(a: Int, b: Int): Unit {
        println(a)
    }

    fun printInt1(a: Int, b: Int) {
        println(a)
    }

    //遍历数组
    fun forLoop(array: Array<String>) {

        for (str in array) {
            println(str)
        }


        array.forEach {
            println(it)
        }

        for (i in array.indices) {
            println(array[i])
        }

        val i = 0
        while (i < array.size) {
            println(anyArray[i])
        }

    }

    //使用when 判断类型
      fun   whenMethord(obj:Any){
        when(obj){
            1 -> println(1)
            234-> println(234)
            "String" -> println("String")
            is Long -> println("Number is Long")
            !is  Int -> println("Not  Int")
            is  Short ->{
                println("{-----Short------}")
            }
            else ->  println("Nothing else")
        }
    }

    fun   KtStudent(name:String){
        println("name:$name")
        Log.i("1111","name:$name")
    }




}

fun main2() {

}