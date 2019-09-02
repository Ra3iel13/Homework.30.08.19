package com.example.homework300819.view


import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.homework300819.R
import com.example.homework300819.models.Articles
import com.example.homework300819.models.NewsModel
import com.example.homework300819.presenter.ArticlesPresenter
import com.example.homework300819.presenter.ArticlesView
import com.example.homework300819.presenter.ArticlesViews
import com.example.homework300819.presenter.Presenter
import kotlinx.android.synthetic.main.fragment_articles.*


class ArticlesFragment : Fragment() , ArticlesViews{

   //private val articlesPresenter=ArticlesPresenter()
    private lateinit var presenter: Presenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_articles, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //articlesPresenter.onViewAttached(this)
        presenter = Presenter(this)
        presenter.showArticle()

    }

    override fun showLoading() {
    }

    override fun showArticles(newsModel: NewsModel) {

        Log.d("IamERROR", "errrr"+newsModel.articles[0].author)

        val adaptor:Adaptor= Adaptor(newsModel!!,object:OnArticlesClick{


            override fun onArtivlesClick(articles: Articles) {

                val url =articles.url
                val builder= CustomTabsIntent.Builder()
                val customTabsIntent=builder.build()
                customTabsIntent.launchUrl(activity, Uri.parse(url))


            }

        })
        rv_Art.layoutManager=LinearLayoutManager(activity)
        rv_Art.adapter=adaptor
    }





































    /*  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)


      }*/
   /* override fun showLoading() {
    }

   override fun showArticles(json4kotlinBase: Json4Kotlin_Base) {
        Log.d("Aticles",json4kotlinBase.articles[0].title)

        val adaptor:Adaptor= Adaptor(json4kotlinBase)
        rv_Art.layoutManager=LinearLayoutManager(activity)
        rv_Art.adapter=adaptor


    }*/


}
