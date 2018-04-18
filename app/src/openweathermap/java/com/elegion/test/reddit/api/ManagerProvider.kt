package com.elegion.test.reddit.api

import com.elegion.test.reddit.weather.OpenWeatherManager

/**
 * Created by Vladislav Falzan.
 */
class ManagerProvider {

    companion object {
        fun provide() = OpenWeatherManager()
    }
}