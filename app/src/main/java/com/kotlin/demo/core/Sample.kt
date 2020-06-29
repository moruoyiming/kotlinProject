package com.kotlin.demo.core




fun main() {
    //泛型增加扩展函数


    login("jianruilijn", "123456") {
        if (it) {
            println()
        } else {
            println()
        }

    }
    loginEngine("jianruilijn", "123456") {
        if (it) {
            println()
        } else {
            println()
        }

    }

    //有返回值
    loginTest() {
        true
    }
}

public fun login(username: String, password: String, responseResult: (Boolean) -> Unit) {
    loginEngine(username, password, responseResult)
}

//内部去完成登录功能
private fun loginEngine(username: String, password: String, responseResult: (Boolean) -> Unit) {
    if (true) {
        responseResult(true)
    } else {
        responseResult(false)
    }
}

//有返回值
fun loginTest(mm: () -> Boolean) {

}

//高阶函数有返回值      方法有返回值
//mm: () -> Boolean   : Int
fun loginTest2(mm: () -> Boolean): Int { //方法返回值
    return 998
}