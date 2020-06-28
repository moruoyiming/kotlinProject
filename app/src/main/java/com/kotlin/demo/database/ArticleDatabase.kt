package com.kotlin.demo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// java entities = {}
// kt entities = []
@Database(entities = [Article::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        private var INSTANCE: ArticleDatabase? = null

        fun getDatabase(context: Context): ArticleDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    ArticleDatabase::class.java,
                    "article_database.db"
                )//数据库名称
                    //允许主线程运行
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

        fun getDataBase(): ArticleDatabase? = INSTANCE
    }
}