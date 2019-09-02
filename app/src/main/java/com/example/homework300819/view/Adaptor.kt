package com.example.homework300819.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework300819.R
import com.example.homework300819.models.Articles
import com.example.homework300819.models.NewsModel
import kotlinx.android.synthetic.main.row.view.*

class Adaptor(private val newsModel: NewsModel, private val listener: OnArticlesClick):
    RecyclerView.Adapter<Adaptor.ArticlesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesHolder {
        return ArticlesHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row,parent,false
            )
        )

    }

    override fun getItemCount(): Int {
        return newsModel.articles.size
    }

    override fun onBindViewHolder(holder: ArticlesHolder, position: Int) {
        holder.title.text=newsModel.articles[position].title
        holder.description.text=newsModel.articles[position].author
        holder.bind(newsModel.articles[position],listener)

    }
    class ArticlesHolder (view: View): RecyclerView.ViewHolder(view){

        val title = view.tvTitle
        val description=view.txView2

        fun bind(result: Articles,listener: OnArticlesClick){
            itemView.setOnClickListener{
                listener.onArtivlesClick(result)
            }
        }

    }


}

interface OnArticlesClick{
    fun onArtivlesClick(articles: Articles)
}




































