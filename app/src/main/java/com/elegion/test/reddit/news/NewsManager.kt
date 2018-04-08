package com.elegion.test.reddit.news

import com.elegion.test.reddit.api.RestApi
import com.elegion.test.reddit.model.RedditNewsItem
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Consumer

/**
 * Created by Vladislav Falzan.
 */
class NewsManager(private val api: RestApi = RestApi()) {

    fun getNews(limit: String = "10"): Single<List<RedditNewsItem>> {
        return Single.create {
            emitter ->
            val apiResponse = api.getNews("", limit)
            apiResponse.subscribe({
                response ->
                val news = response.data.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                emitter.onSuccess(news)
            })
        }
    }
}