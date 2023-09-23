package com.mozylee.lecture18

import com.lannstark.lec17.Fruit

fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_001),
        Fruit("사과", 1_002),
        Fruit("사과", 1_003, 1_003),
        Fruit("바나나", 1_004),
        Fruit("사과", 2_000, 2_000),
        Fruit("포도", 2_001, 2_001),
    )

    val isFruitApple: (Fruit) -> Boolean = { fruit -> fruit.name == "Apple" }

    val areAllFruitsApples = fruits.all(isFruitApple) // fruits.all { fruit -> fruit.name == "Apple" }
    val areNoFruitsApples = fruits.none(isFruitApple)
    val areAnyFruitsApples = fruits.any(isFruitApple)

    println(fruits.count()) // 크기

    val sortedFruits = fruits.sortedBy { fruit -> fruit.price } // 가격순 정렬
    val sortedDescendingFruits = fruits.sortedByDescending { fruit -> fruit.price } // 가격역순 정렬
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.name }

    val firstFruit = fruits.first() // fruits가 비어 있다면 exception
    val firstFruitOrNull = fruits.firstOrNull()

    val fruitMap: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
    // key, value 둘다 만들어 줄 수 있음
    val fruitPriceMap: Map<String, List<Int>> = fruits.groupBy({ fruit -> fruit.name }, { fruit -> fruit.price })

    val fruitsList = listOf(
        listOf(
            Fruit("사과", 1_000),
            Fruit("사과", 1_001),
            Fruit("사과", 1_002),
            Fruit("사과", 1_003, 1_003),
            Fruit("바나나", 1_004),
            Fruit("사과", 2_000, 2_000),
            Fruit("포도", 2_001, 2_001),
        ),
        listOf(
            Fruit("사과", 1_000),
            Fruit("사과", 1_001),
            Fruit("사과", 1_002),
            Fruit("사과", 1_003, 1_003),
            Fruit("바나나", 1_004),
            Fruit("사과", 2_000, 2_000),
            Fruit("포도", 2_001, 2_001),
        ),
        listOf(
            Fruit("사과", 1_000),
            Fruit("사과", 1_001),
            Fruit("사과", 1_002),
            Fruit("사과", 1_003, 1_003),
            Fruit("바나나", 1_004),
            Fruit("사과", 2_000, 2_000),
            Fruit("포도", 2_001, 2_001),
        )
    )

    // 아래는 flatList를 만드는 여러가지 방법
    val samePriceFruits = fruitsList.flatMap { list -> list.filter { fruit -> fruit.isTheSamePrice } }
    val samePriceFruits2 = fruitsList.flatMap { list -> list.filter { fruit -> fruit.isTheSamePrice } }
    val samePriceFruits3 = fruitsList.flatMap { list -> list.filterTheSamePrice }

    val samePriceFruits4 = fruitsList.flatten()
        .filter { fruit -> fruit.factoryPrice == fruit.price }
}

val Fruit.isTheSamePrice: Boolean
    get() = this.factoryPrice == this.price

val List<Fruit>.filterTheSamePrice: List<Fruit>
    get() = this.filter(Fruit::isTheSamePrice)

