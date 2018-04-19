package com.elegion.test.reddit.api

import com.elegion.test.reddit.weather.WorldWeatherManager


/**
 * Created by Vladislav Falzan.
 */
class ManagerProvider {

    companion object {
        fun provide() = WorldWeatherManager()
    }
}