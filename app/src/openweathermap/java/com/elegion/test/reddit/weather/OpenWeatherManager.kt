package com.elegion.test.reddit.weather

import com.elegion.test.reddit.BuildConfig
import com.elegion.test.reddit.api.OpenWeatherRestApi
import com.elegion.test.reddit.common.RestApi
import com.elegion.test.reddit.model.Weather
import io.reactivex.Single

/**
 * Created by Vladislav Falzan.
 */
class OpenWeatherManager(private val mApi: RestApi = OpenWeatherRestApi()) {

    fun getWeather(args: String = BuildConfig.API_ARGS): Single<List<Weather>> {
        return Single.create {
            emitter ->
            val apiResponse = mApi.getWeather(args)
            apiResponse.subscribe({
                response ->
                emitter.onSuccess(response.mList)
            })
        }
    }
}