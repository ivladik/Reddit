package com.elegion.test.reddit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Vladislav Falzan.
 */
data class CurrentCondition (
        @SerializedName("temp_C")
        val mTemperature: Int,
        @SerializedName("humidity")
        val mHumidity: Int
)