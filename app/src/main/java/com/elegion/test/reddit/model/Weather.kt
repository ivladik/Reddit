package com.elegion.test.reddit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Vladislav Falzan.
 */
data class Weather(
        @SerializedName("id")
        val mId: Int, // todo: make private and customize setter/getter
        @SerializedName("name")
        val mCityName: String,
        @SerializedName("main")
        val mTemperatureObject: Main
)