package com.elegion.test.reddit.manager

import com.elegion.test.reddit.BuildConfig
import com.elegion.test.reddit.api.OpenWeatherRestApi
import com.elegion.test.reddit.common.BaseWeatherModel
import com.elegion.test.reddit.common.RestApi
import io.reactivex.Single

/**
 * Created by Vladislav Falzan.
 */
class OpenWeatherManager(private val mApi: RestApi = OpenWeatherRestApi()) {

    fun getWeather(args: String = BuildConfig.API_ARGS): Single<List<BaseWeatherModel>> {
        return Single.create {
            emitter ->
            val apiResponse = mApi.getWeather(args)
            apiResponse.subscribe({
                response ->
                val dataList = response.mList.map {
                    BaseWeatherModel(
                            it.mCityName,
                            it.mTemperatureObject.mTemperature,
                            it.mTemperatureObject.mHumidity
                    )
                }
                emitter.onSuccess(dataList)
            })
        }
    }
}