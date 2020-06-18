package com.kotlin.demo.beans

/**
 * <pre>
 *     author: jian
 *     Date  : 2020/6/18 8:28 PM
 *     Description:
 * </pre>
 */
data class LoginResponseWrapper<T>(val data: T, val errorCode: Int, val errorMsg: String) {
}