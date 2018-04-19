package com.elegion.test.reddit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Vladislav Falzan.
 */
data class WeatherResponse(
        @SerializedName("data")
        val mData: Data
)