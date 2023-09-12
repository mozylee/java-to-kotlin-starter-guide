package com.mozylee.lecture16


fun main(){
    println(3.add(4))
    println(3.add2(4))
    println(3 add2 4)
}

fun Int.add(other:Int):Int{
    return this+other
}

infix fun Int.add2(other:Int):Int{
    return this+other
}