package com.example.homework300819.presenter

import android.util.Log
import com.example.homework300819.common.Constants
import com.example.homework300819.models.NewsModel
import com.example.homework300819.network.ArticlesInterface
import com.example.homework300819.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticlesPresenter : BasePresenter<ArticlesView>(){
    override fun onViewAttached(view: ArticlesView) {
        super.onViewAttached(view)
        view.showLoading()

        val articlesRequest = RetrofitInstance().retrofitInstance.create(ArticlesInterface::class.java)
        val call = articlesRequest.getArticoes(Constants.COUNTRY,Constants.API_KEY)
        call.enqueue(object : Callback<NewsModel> {
            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                Log.d("masage", "error"+t.message)
            }

            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                val res = response.body()
                Log.d("masage2", "erroor"+res!!.articles[0].author)

                view.showArticles(res!!)

            }

        });


    }
}

interface ArticlesView: BasePresenter.View {

    fun showLoading()
    fun showArticles(newsModel: NewsModel)

}