package com.taichi.mybasekoltin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taichi.mybasekoltin.kttest.Color
import com.taichi.mybasekoltin.kttest.Data
import com.taichi.mybasekoltin.kttest.userBean

class MainActivity : AppCompatActivity() {
    var u: userBean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        u?.code = 20001
        var data: Data? = u?.data

        data?.user_id = ""

        loop@ for (i in 0..2) {
            for (j in 0..3) {
                println("i:$i j:$j")
                if (j == 2) {
                    break@loop
                }
            }
        }

        for (i in 5 downTo 0) {
            println(i)
        }

        for (i in 1..5) {
            println(i)
        }
        for (i in 1..5 step 2) {
            print(i)
        }

        for (i in 5 downTo 1 step 3) {
            print(i)
        }


        fun display() {
            var color: Color = Color.BLACK;
            Color.valueOf("BLUE")
            Color.values()
            println(color.name)
            println(color.ordinal)
        }
        display()

        //可变集合
        val mutableList = mutableListOf(1, 2, 3, 4)
        mutableList.add(5)
        println(mutableList)
        mutableList.addAll(2, setOf(4, 5))
        println(mutableList)

        val mutableListOf = mutableListOf<String>("one", "two")
        mutableListOf += "three"
        println(mutableListOf)
        mutableListOf += listOf<String>("four", "five")
        println(mutableListOf)

        val mutableListOf1 = mutableListOf(1, 2, 3, 4, 5, 7, 8, 9)
        /*  mutableListOf1.remove(3)
          println(mutableListOf1)
          mutableListOf1.remove(6)//删除的是元素值
          println(mutableListOf1)*/
        /*      mutableListOf1.retainAll {
                  it>=3
              }
              println(mutableListOf1)*/
        mutableListOf1.removeAll(setOf(1, 2, 9))
        println(mutableListOf1)


        val listOf = listOf(1, 2, 3, 4)
        println(listOf.get(0))
        println(listOf[0])
        println(listOf.getOrNull(5))
        println(listOf.getOrElse(5) { it })

        var numbers = (1..13).toList()
        //  1,2,3,4,5,6
        println(numbers.subList(3, 5))//索引检索 0开始
        val listOf1 = listOf(1, 2, 3, 4, 5, 6)
        println(listOf1.indexOf(2))//通过元素值获取索引
        println(listOf1.indexOf(7))
        println(listOf1.lastIndexOf(5))

        val mutableListOf2 = mutableListOf(1, 2, 3, 4)
        println(mutableListOf2.indexOfFirst {
            it >= 2
        })
        println(mutableListOf2.indexOfLast {
            it % 2 == 1//2
        })

        val numbers1 = mutableListOf(1, 2, 3, 4)
        numbers1.fill(3)//将所有集合元素的值替换为指定值
        println(numbers1)

        //删除指定位置索引的元素值
        val mutableListOf3 = mutableListOf(1, 2, 3, 4, 5)
        println(mutableListOf3.removeAt(1))
        println(mutableListOf3)

        val mutableListOf4 = mutableListOf("one", "two", "three", "four", "five")
        mutableListOf4.sort()
        println("Sort into ascending: $mutableListOf4")
        mutableListOf4.sortDescending()
        println("Sort into descending: $mutableListOf4")
        val mutableListOf5 = mutableListOf(3, 2, 4, 5, 60, 8, 1)
        mutableListOf5.sort()
        println("Sort into ascending: $mutableListOf5")
    }

    fun main(args: Array<String>) {

    }


}
