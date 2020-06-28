package com.kotlin.demo.core

fun main() {
    // () -> Unit  空参函数  没有返回值  函数名=method1
    var method1: () -> Unit//返回为null
//    method1()//不能调用 没有具体实现

    //(Int, Int) -> Int
    var method2: (Int, Int) -> Int
//    method2(9, 9)

    var method3: (String, Double) -> Any?

    var method4: (Int, Double, String?) -> Any?

    var method5: (Int, Double) -> Any?

    // 以上方法定义没有问题，调用不行

//     :(行参类型) 小括号 需要将行参类型传入
    var method6: (Int, Double) -> Double = { number1, number2 -> number1 + number2 }
//     ={具体详情}
    var method7 = { number1: Int, number2: Int -> number1 + number2 } //类型推导  返回Int类型
    println("method7:${method7(100, 100)}")

    var method8: (String, String) -> Unit =
        { astring, bstring -> println("a:${astring} b:${bstring}") }
    println("method8:${method8("李渊", "chengyaojin")}")

    var method9: (String) -> String = { str -> str }
    println("method9:${method9("波多野结衣")}")

    var method10: (Int) -> Unit = {
        when (it) {
            10 -> println("波多野结衣")
            in 20..30 -> println("小泽玛利亚")
            else -> print("不知道是谁")
        }
    }
    method10(19)

    var method11: (Int, Int, Int) -> Unit = { n1, n2, n3 ->
        println("n1:${n1} n2:${n2} n3:${n3}")
    }

    var method12 = { println("sdfasdfasdfs") }
    method12()

    var method13 = { sex: Char -> if (sex == 'M') "代表是男" else "代表是女" }
    println("method13 : ${method13('M')}")

    //覆盖操作
    var method14 = { number: Int -> println("我就是m14 我的值:$number") }
    method14 = { println(" 覆盖 我的值 ${it}") }
    println(method14(15))

    // 需求  打印并返回
    var method15 = { number: Int -> println("打印打印 $number ")
        number+10000
        println("返回")
    }

    println("method15 :${method15(13123)}")

}
