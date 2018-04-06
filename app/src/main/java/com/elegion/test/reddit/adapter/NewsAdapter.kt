package com.elegion.test.reddit.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.elegion.test.reddit.R
import com.elegion.test.reddit.model.RedditNewsItem

/**
 * Created by Vladislav Falzan.
 */
class NewsAdapter : RecyclerView.Adapter<NewsHolder>() {

    private var news: ArrayList<RedditNewsItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.news_item, parent, false)
        return NewsHolder(v)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: NewsHolder?, position: Int) {
        val item = news[position]
        holder?.bind(item)
    }

    fun addNews(newItems: List<RedditNewsItem>) {
        news.clear()
        news.addAll(newItems)
        notifyDataSetChanged()
    }
}