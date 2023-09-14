package com.mozylee.lecture19

import com.mozylee.lecture14.Person
import com.lannstark.lec18.B as Lec18
import com.lannstark.lec19.B as Lec19

typealias IncredibleMap = Map<String, SomethingVeryIncredibleClass>

fun main() {
    // typealias
    val incredibleMap: Map<String, SomethingVeryIncredibleClass> = mapOf("이이이잉" to SomethingVeryIncredibleClass(a = "이이잉", b = "이이잉"))
    val incredibleMap2: IncredibleMap = mapOf("타입이" to SomethingVeryIncredibleClass(a = "축약", b = "되어 버렸다."))

    // 동일한 클래스명이지만, as import를 활용 가능
    // Lec18.printHelloWorld()
    // Lec19.printHelloWorld()

    // data class는 property의 순서에 따라 componentN method를 자동으로 만들어준다.
    val somethingVeryIncredibleClass = SomethingVeryIncredibleClass(a = "이정주", b = "일을 안하고도 돈을 벌고 싶다.")

    val (a, b) = somethingVeryIncredibleClass
    val a2 = somethingVeryIncredibleClass.component1();
    val b2 = somethingVeryIncredibleClass.component2();

    println("${a}는 ${b}")

    val somethingAwesomeClass = SomethingAwesomeClass(a = "a", b = "b")

    val (aa, bb) = somethingAwesomeClass

    println("${aa}, ${bb}")

    test()
}

data class SomethingVeryIncredibleClass(
    val a: String,
    val b: String,
)

class SomethingAwesomeClass(
    private val a: String,
    private val b: String,
) {
    // data class가 아닌 class에서 componentN를 사용하려면 아래와 같이 선언해야 한다.
    operator fun component1(): String = this.a
    operator fun component2(): String = this.b
}

// 아래 함수 세개는 같은 역할을 하는 함수이다.
fun getNumberOrNull(number: Int): Int? {
    return if (number <= 0) {
        null
    } else {
        number
    }
}

fun getNumberOrNull2(number: Int): Int? {
    // 조건문을 만족하면 number가, 그렇지 않다면 null이 반환된다.
    return number.takeIf { number > 0 }
}

fun getNumberOrNull3(number: Int): Int? {
    return number.takeUnless { number <= 0 }
}

fun test() {
    val number = getNumberOrNull(-2) ?: 0

    println(number) // 0
}