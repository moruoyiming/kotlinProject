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

    //删除全部
    @Query("DELETE FROM article_collection")
    fun deleteArticles()


    @Query("SELECT * FROM article_collection ORDER BY ID DESC")
    fun queryArticles(): List<Article>

//    @Query("SELECT article FROM article_collection")
//    fun selectArticle(article: Article)
//
//    @Query("DELETE article FROM article_collection")
//    fun deleteArticle(article: Article)
}