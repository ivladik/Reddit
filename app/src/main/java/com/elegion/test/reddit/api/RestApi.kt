package com.elegion.test.reddit.api

import com.elegion.test.reddit.model.RedditNewsItem
import com.elegion.test.reddit.model.RedditNewsResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Vladislav Falzan.
 */
class RestApi {

    private val restApi: RedditApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        restApi = retrofit.create(RedditApi::class.java)
    }

    fun getNews(after: String, limit: String): Single<RedditNewsResponse> {
        return restApi.getTop(after, limit)
    }
}