package com.elegion.test.reddit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Vladislav Falzan.
 */
data class Main(
        @SerializedName("temp")
        val mTemperature: Double,
        @SerializedName("humidity")
        val mHumidity: Int)