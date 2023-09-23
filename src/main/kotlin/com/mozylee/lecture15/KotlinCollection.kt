package com.mozylee.lecture15

fun main() {
    val emptyList = emptyList<Int>() // 타입 선언 필요
    getEmptyList(emptyList()) // 타입 추론 가능하므로, 선언 안해도 됨

    val list = listOf(100, 200)
    println(list[1]) // index 접근 가능 (get() 안써도 됨)

    // list.add() // 기본적으로 immutable 이라 add 불가
    // forEach 활용 가능
    list.forEachIndexed { index, number ->  println("index${index}: ${number}")}

    // 가변 리스트 (구현체는 ArrayList, Java 의 리스트와 유사)
    val numbers = mutableListOf(100, 200)
    numbers.add(500)

    // Set, Map도 유사
    // MutableSet의 경우, LinkedHashSet이 기본 구현체
    // MutableMap의 경우, LinkedHashMap이 기본 구현체

    val map = mutableMapOf<String, String>()
    map["키"] = "밸류" // map.put("키", "밸류")
    map["key"] = "value"
    // map["key"] = null // String type이라 null 불가

    val pairInitialMap = mutableMapOf("키" to "밸류", "key" to "value")

    pairInitialMap.forEach { key, value -> println("${key} : ${value}") }
}

fun getEmptyList(list: List<Int>) {

}