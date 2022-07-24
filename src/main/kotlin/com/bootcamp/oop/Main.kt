package com.bootcamp.oop

//import com.bootcamp.oop.utils.PI
//import com.bootcamp.oop.utils.factorial
//import com.bootcamp.oop.utils.pow
//import com.bootcamp.oop.utils.sayHello

import com.bootcamp.oop.utils.*

fun main(){
    sayHello()
    println(factorial(4.0))
    println(pow(3.0, 2.0))
    println(PI)
    println(areaOfCircle(13.0))

    val someStringValue: String? = null
    var someIntValue: Int = 12

    try {
        someIntValue = someStringValue!!.toInt()
    } catch (e: NullPointerException) {
        someIntValue = 0
    } catch (e: NumberFormatException) {
        someIntValue = -1
    } finally {
        when(someIntValue){
            0 -> println("Catch block NullPointerException terpanggil!")
            -1 -> println("Catch block NumberFormatException terpanggil!")
            else -> println(someIntValue)
        }
    }
}