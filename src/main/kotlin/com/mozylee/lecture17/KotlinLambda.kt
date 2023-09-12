package com.mozylee.lecture17

import com.lannstark.lec17.Fruit

fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_001),
        Fruit("사과", 1_002),
        Fruit("사과", 1_003),
        Fruit("바나나", 1_004),
        Fruit("사과", 2_000),
        Fruit("포도", 2_001),
    )

    // (parameters...) -> return type
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

    isApple(fruits[0])
    isApple.invoke(fruits[1])

    // 람다 호출 방법 (가장 정석적이고 많이 사용하는 방법)
    filterFruits(fruits) { fruit -> fruit.name == "사과" }

    // 함수를 parameter로 넘기기
    filterFruits(fruits, isApple)

    // fruit -> fruit.name을 줄여서 it.name으로 변경 가능 (근데 웬만하면 쓰지마세요.)
    filterFruits(fruits) { it.name == "사과" }

    // 여러 줄인 경우, 마지막 expressiond의 결과값이 람다의 결과값
    filterFruits(fruits) { fruit ->
        println("여러 줄인 경우 마지막 expression이 결과값")

        fruit.name == "사과"
    }
}

fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val result = mutableListOf<Fruit>()

    for (fruit in fruits) {
        if (fruit !in fruits) {
            continue
        }

        result.add(fruit)
    }

    return result
}