package com.elegion.test.reddit.api

import com.elegion.test.reddit.model.RedditNewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Vladislav Falzan.
 */
interface RedditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String,
               @Query("limit") limit: String
    ): Single<RedditNewsResponse>
}