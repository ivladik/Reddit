package com.elegion.test.reddit.api

import com.elegion.test.reddit.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Vladislav Falzan.
 */
interface WeatherService {

    @GET("data/2.5/box/city?units=metric")
    fun getWeather(@Query("bbox") bbox: String): Single<WeatherResponse>
}