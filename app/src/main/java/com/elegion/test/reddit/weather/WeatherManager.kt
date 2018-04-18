package com.elegion.test.reddit.weather

import com.elegion.test.reddit.BuildConfig
import com.elegion.test.reddit.api.RestApi
import com.elegion.test.reddit.model.Weather
import io.reactivex.Single

/**
 * Created by Vladislav Falzan.
 */
class WeatherManager(private val mApi: RestApi = RestApi()) {

    fun getWeather(bbox: String = BuildConfig.API_ARGS): Single<List<Weather>> {
        return Single.create {
            emitter ->
            val apiResponse = mApi.getWeather(bbox)
            apiResponse.subscribe({
                response ->
                emitter.onSuccess(response.mList)
            })
        }
    }
}