package com.taichi.mybasekoltin.kttest

open  class People  constructor(var id:String , var  name:String){
    var   customName = name.toUpperCase()
    constructor(id:String,name: String,age:Int):this(id,name){
        println("construtor")
    }

}