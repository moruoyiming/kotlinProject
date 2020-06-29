package com.kotlin.demo.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.demo.R
import com.kotlin.demo.database.Article

/**
 * 同学们这是 “收藏” 列表的适配器
 */
class CollectAdapter : RecyclerView.Adapter<CollectAdapter.MyViewHolder>() {

    // 内部类
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvID: TextView = itemView.findViewById(R.id.tv_id)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvAge: TextView = itemView.findViewById(R.id.tv_age)
    }

    // 接收 数据库的数据
    var allStudents: List<Article> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Item 布局
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val itemView: View = layoutInflater.inflate(R.layout.item_collect_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = allStudents.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val article: Article = allStudents[position]
        holder.tvID.text = "${position + 1}"
        holder.tvName.text = article.title
        holder.tvAge.text = "${article.author}"

        // 点击Item的时候，可以跳转到  有道词典 查询
        holder.itemView.setOnClickListener {
            val uri: Uri = Uri.parse("https://m.youdao.com/dict?le=eng&q=" + holder.tvName.text)
            val intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri;
            holder.itemView.context.startActivity(intent)
        }
    }

}