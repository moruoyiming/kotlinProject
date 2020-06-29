package com.kotlin.demo.database

import androidx.room.*

@Dao  //数据库的增删改查
interface ArticleDao {
    //vararg 可变参数
    //void main(String... args) vs vararg article: Article
    @Insert
    fun insertArticles(vararg article: Article)

    @Update
    fun updateArticles(vararg article: Article)

    @Delete
    fun deleteArticles(vararg article: Article)

    // 删除全部
    @Query("DELETE FROM article")
    fun deleteAllArticle()

    @Query("SELECT * FROM article ORDER BY ID DESC")
    fun queryAllArticles(): List<Article>


}