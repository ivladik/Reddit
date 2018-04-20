package com.elegion.test.reddit.weather

import com.elegion.test.reddit.BuildConfig
import com.elegion.test.reddit.api.WorldWeatherRestApi
import com.elegion.test.reddit.common.BaseWeatherModel
import com.elegion.test.reddit.common.RestApi
import io.reactivex.Single
import java.util.*

/**
 * Created by Vladislav Falzan.
 */
class WorldWeatherManager(private val mApi: RestApi = WorldWeatherRestApi()) {

    fun getWeather(args: String = BuildConfig.API_ARGS): Single<List<BaseWeatherModel>> {
        return Single.create {
            emitter ->
            val apiResponse = mApi.getWeather(args)
            apiResponse.subscribe({
                response ->
                val data = response.mData
                val model = BaseWeatherModel(
                            data.mRequest[0].mCityName,
                            data.mCurrentCondition[0].mTemperature.toDouble(),
                            data.mCurrentCondition[0].mHumidity
                    )
                emitter.onSuccess(listOf(model))
            })
        }
    }
}