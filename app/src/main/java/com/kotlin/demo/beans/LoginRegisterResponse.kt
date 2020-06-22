package com.kotlin.demo.beans

/**
 * <pre>
 *     author: jian
 *     Date  : 2020/6/18 8:30 PM
 *     Description:
 * </pre>
 */
// 通配符 Java ?      KT  *
data class LoginRegisterResponse(
    val admin: Boolean,
    val chapterTops: List<*>,
    val collectIds: List<*>,
    val email: String?,
    val icon: String?,
    val id: Int,
    val nickname: String,
    val password: String?,
    val publicName: String,
    val token: String?,
    val type: Int,
    val username: String

) {
}