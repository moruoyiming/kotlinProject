package com.kotlin.demo.core

val name: String = "Jianruilin"
val age: Int = 0

fun common() {
    println("我就是方法")
}

fun main() {
    //泛型增加扩展函数
    var xx = common().run {
        "方法XXX"
    }
    println(xx)
    var xx2 = common().run2 {
        "方法XXX"
    }
    println(xx2)

    var xx3 = common().myRun(){
        "方法XXX"
    }
    println(xx3)


    name.myLet() {
        "xxx"
    }
}

fun <T, R> T.run(mm: T.() -> R): R {
    return mm()
}
//打印的结果
//我就是方法
//方法XXX


// T.() 给泛型增加匿名函数  只不过匿名函数在高阶函数中  -> R 高阶函数返回值是R
// : R T.run2 函数返回值是 R       两个R 没有半毛钱关系
fun <T, R> T.run2(mm: T.() -> R): R = mm()
//打印的结果
//我就是方法
//方法XXX



// T.() 给泛型增加匿名函数  只不过匿名函数在高阶函数中  -> R 高阶函数返回值是R
// ()高阶函数
fun <T> T.myRun(mm: T.() -> String) {
    mm()
}

// 普通函数
fun <T, R> myWith(intput: T, mm: T.() -> R): R {
    return intput.mm()
}

//T.myLet 给泛型 T 声明扩展函数
fun <T, R> T.myLet(mm: T.() -> R): R {
//    T.(T)  代表就是 mm(this)    T ==this    ()->R
    return mm(this)
}

//T.myLet 给泛型 T 声明扩展函数
fun <T, R> T.myLet2(mm: T.(T) -> R): R {
//  mm(this) ==this  vs    T.(T)->R
    return mm(this)
}