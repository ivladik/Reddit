package com.elegion.test.reddit.api

import com.elegion.test.reddit.BuildConfig
import com.elegion.test.reddit.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Vladislav Falzan.
 */
interface WeatherService {

    @GET(BuildConfig.API_GET)
    fun getWeather(@Query(BuildConfig.API_ARGS_NAME) args: String): Single<WeatherResponse>
}