package com.elegion.test.reddit.api

import com.elegion.test.reddit.common.RestApi
import com.elegion.test.reddit.model.WeatherResponse
import io.reactivex.Single

/**
 * Created by Vladislav Falzan.
 */
class WorldWeatherRestApi : RestApi() {

    override fun getWeather(args: String): Single<WeatherResponse> {
        return mRestApi.getWeather(args)
    }
}