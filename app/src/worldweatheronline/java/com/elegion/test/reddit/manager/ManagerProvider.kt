package com.elegion.test.reddit.manager

import com.elegion.test.reddit.weather.WorldWeatherManager


/**
 * Created by Vladislav Falzan.
 */
class ManagerProvider {

    companion object {
        fun provide() = WorldWeatherManager()
    }
}