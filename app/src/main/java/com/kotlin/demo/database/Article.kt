package com.kotlin.demo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 文章实体bean
 */
@Entity(tableName = "article_collection")
class Article() {
    //主键  自动增长
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "title") //可以增加别名，优先级更高
    lateinit var title: String

    @ColumnInfo(name = "author")
    lateinit var author: String

    //次构造函数
    constructor(title: String, author: String) : this() {
        this.title = title
        this.author = author
    }
}