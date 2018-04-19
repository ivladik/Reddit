package com.elegion.test.reddit.api

import com.elegion.test.reddit.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by Vladislav Falzan.
 */
class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val httpUrl = request.url().newBuilder()
                .addQueryParameter(BuildConfig.API_KEY_PREFIX, BuildConfig.API_KEY)
                .build()
        return chain.proceed(request.newBuilder().url(httpUrl).build())
    }
}