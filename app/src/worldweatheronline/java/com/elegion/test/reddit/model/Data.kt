package com.elegion.test.reddit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Vladislav Falzan.
 */
data class Data (
        @SerializedName("request")
        val mRequest: List<Request>,
        @SerializedName("current_condition")
        val mCurrentCondition: List<CurrentCondition>
)