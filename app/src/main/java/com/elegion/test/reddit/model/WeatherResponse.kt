package com.elegion.test.reddit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Vladislav Falzan.
 */
data class WeatherResponse(
        @SerializedName("list")
        val mList: List<Weather>
)