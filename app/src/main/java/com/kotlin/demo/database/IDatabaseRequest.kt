package com.kotlin.demo.database

/**
 * 为了扩展，这样写（在仓库里面的）
 * 数据库获取标准接口（在仓库里面） 也就是数据库的数据读取（包括数据库数据，等）
 * 只为 LocalRoomRequestManager 服务
 *
 * DB 数据
 */
interface IDatabaseRequest {

    fun insertArticles(vararg article: Article)

    fun updateArticles(vararg article: Article)

    fun deleteArticles(vararg article: Article)

    fun deleteAllArticle()

    fun queryAllArticle() : List<Article> ?

    // TODO 可扩展 ...

}