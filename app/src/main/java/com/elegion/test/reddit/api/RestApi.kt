package com.elegion.test.reddit.api

import com.elegion.test.reddit.BuildConfig
import com.elegion.test.reddit.model.WeatherResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Vladislav Falzan.
 */
class RestApi {

    private val mRestApi: WeatherService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        mRestApi = retrofit.create(WeatherService::class.java)
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(ApiKeyInterceptor())
                .addInterceptor(HttpLoggingInterceptor())
                .build()
    }

    fun getWeather(bbox: String): Single<WeatherResponse> {
        return mRestApi.getWeather(bbox)
    }
}