package com.mozylee.lecture15

fun main() {
    val array = arrayOf(100, 200)

    // copy and add
    val array2 = array.plus(300)
    for ((index, value) in array2.withIndex()) {
        println("index${index}: ${value}")
    }

    array2.forEachIndexed { index, value -> println("index${index}: ${value}") }
}