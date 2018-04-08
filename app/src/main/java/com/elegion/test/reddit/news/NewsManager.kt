package com.elegion.test.reddit.news

import com.elegion.test.reddit.model.RedditNewsItem
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Vladislav Falzan.
 */
class NewsManager {

    fun getNews(): Single<List<RedditNewsItem>> {
        return Single.create {
            emitter ->
            val news = (1..10).map {
                RedditNewsItem(
                        "author$it",
                        "Title $it",
                        it, // number of comments
                        1457207701L - it * 200, // time
                        "http://lorempixel.com/200/200/technics/$it", // image url
                        "url"
                )
            }
            emitter.onSuccess(news)
        }
    }
}