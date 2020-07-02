package com.kotlin.demo.core

fun main() {
    method01() {
        "返回值$it"
    }
    var xxx = {
        "xxcvsdefs"
    }
    println(xxx)
    method02(12312, {
        "xxx" + it
    })

    method03(12312, {
        println("age: $it")
    })

    method04(15)
    println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
    method01(::method04)
}

fun method01(mm: (Int) -> String) {
    mm(88)
}

fun method02(manys: Int, mm: (Int) -> String) {
    mm(manys)
}

fun method03(age: Int, mm: (Int) -> Unit) {
    println("age: $age")
    mm(age + 10)
}

fun method04(number: Int): String = "OK $number"