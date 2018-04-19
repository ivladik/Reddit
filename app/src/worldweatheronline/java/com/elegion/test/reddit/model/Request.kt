package com.elegion.test.reddit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Vladislav Falzan.
 */
data class Request(
        @SerializedName("query")
        val mCityName: String
)