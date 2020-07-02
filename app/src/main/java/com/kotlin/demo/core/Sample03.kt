package com.kotlin.demo.core

fun main() {
    show1("jianruilin") {
        println("输出: $it ")
    }

    show1("jisdfan", mm = {
        println("输出2: $it")
    })

    show1("dsdsdf", {
        println("输出3: $it")
    })

    show2 {
        println("输出4: $it")
    }

    sun1{
        50
    }

    sun1 {
        println("输出5: $it")
    }

    //两个参数的话，没法默认it  需要手动指定
    sun2 { n1, n2 ->
        println("输出7: $n1  $n2")
    }
    sun3(23,{ n1, n2 ->
//        var n3 = n1+n2
        println("输出8: $age $n1 $n2  ")
    })
}

fun show1(name: String, mm: (String) -> Unit) {
    mm(name)
}

//默认值
fun show2(name: String = "jianruilin", mm: (String) -> Unit) {
    mm(name)
}
//形参 Int  返回值
fun sun1(mm: (Int) -> Unit) {
    mm(89)
}

fun sun2(mm: (Int, Boolean) -> Unit) {
    mm(89, true)
}

fun sun3(age : Int ,mm: (Int, Boolean) -> Unit) {
    println("输出9: $age")
    mm(age, true)
}