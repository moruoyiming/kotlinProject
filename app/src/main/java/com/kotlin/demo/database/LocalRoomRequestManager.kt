package com.kotlin.demo.database


// 仓库角色 本地/DB
class LocalRoomRequestManager : ILocalRequest, IDatabaseRequest {

    // TODO 可扩展 ...

    /** TODO ********************** 下面这一系列都是 本地相关的 ************************/

    var articleDao: ArticleDao? = null

    // Java构造代码块  dao
    init {
        val studentDatabase: ArticleDatabase? = ArticleDatabase.getDataBase()
        articleDao = studentDatabase?.getArticleDao()
    }

    // 单例模式而已
    companion object {
        var INSTANCE: LocalRoomRequestManager? = null

        fun getInstance(): LocalRoomRequestManager {
            if (INSTANCE == null) {
                synchronized(LocalRoomRequestManager::class) {
                    if (INSTANCE == null) {
                        INSTANCE = LocalRoomRequestManager()
                    }
                }
            }
            return INSTANCE!!
        }
    }

    override fun insertArticles(vararg article: Article) {
        articleDao?.insertArticles(*article)
    }

    override fun updateArticles(vararg article: Article) {
        articleDao?.updateArticles(*article)
    }

    override fun deleteArticles(vararg article: Article) {
        articleDao?.deleteArticles()
    }

    override fun deleteAllArticle() {
        articleDao?.deleteAllArticle()
    }

    override fun queryAllArticle(): List<Article>? {
       return articleDao?.queryAllArticles()
    }
//
//    // TODO 增加
//    override fun insertStudents(vararg students: Article) {
//        studentDao?.insertArticles(*students)
//    }
//
//    // TODO 更新
//    override fun updateStudents(vararg students: Article) {
//        studentDao?.updateStudents(*students)
//    }
//
//    // TODO 删除
//    override fun deleteStudents(vararg students: Article) {
//        studentDao?.deleteStudents(*students)
//    }
//
//    // TODO 全部删除
//    override fun deleteAllStudent() {
//        studentDao?.deleteArticles()
//    }
//
//    // TODO 全部查询
//    override fun queryAllStudent() : List<Article>? {
//        return studentDao?.queryAllStudents()
//    }







    /*// TODO 增加
    inner class InsertAsyncTask : AsyncTask<Student, Void, Void>() {
        override fun doInBackground(vararg params: Student): Void? {
            studentDao?.insertStudents(*params)
            return null
        }
    }

    // TODO 更新
    inner class UpdateAsyncTask : AsyncTask<Student, Void, Void>() {
        override fun doInBackground(vararg params: Student): Void? {
            studentDao?.updateStudents(*params)
            return null
        }
    }

    // TODO 删除
    inner class DeleteAsyncTask : AsyncTask<Student, Void, Void>() {
        override fun doInBackground(vararg params: Student): Void? {
            studentDao?.deleteStudents(*params)
            return null
        }
    }

    // TODO 全部删除
    inner class AllDeleteAsyncTask : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            studentDao?.deleteAllStudents()
            return null
        }
    }

    // TODO 全部查询
    inner class AllQueryAsyncTask : AsyncTask<Void, Void, List<Student>>() {
        override fun doInBackground(vararg params: Void?): List<Student> {
            return studentDao?.queryAllStudents()!!
        }
    }*/
}