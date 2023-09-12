package com.mozylee.lecture16

fun main() {
    val str = "ABCD"
    println(str.lastChar()) // D

    val train = Train()
    val srt1: Train = Srt()
    val srt2: Srt = Srt()

    println(srt1 == srt2) // 타입이 다르므로 false

    train.isExpensive() // Train의 확장함수
    srt1.isExpensive() // Train의 확장함수 (기존 Overriding의 바인딩과는 다름. 인스턴스의 타입보다 변수의 타입이 더 중요)
    srt2.isExpensive() // Srt의 확장함수
}

// String에 확장 함수 추가
// fun 수신객체타입.확장함수(): {
//     this //수신객체
// }
fun String.lastChar(): Char {
    return this[this.length - 1]
}

// 확장 함수와 멤버 함수의 시그니처(이름 + 파라미터)가 같으면, 멤버 함수 호출

open class Train(
    val name: String = "기차",
    val price: Int = 5_000,
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")

    return this.price >= 10000
}

class Srt : Train("SRT", 40_000)

fun Srt.isExpensive(): Boolean {
    println("SRT의 확장함수")

    return this.price >= 10000
}