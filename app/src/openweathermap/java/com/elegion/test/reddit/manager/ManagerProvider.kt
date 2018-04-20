package com.elegion.test.reddit.manager

import com.elegion.test.reddit.manager.OpenWeatherManager

/**
 * Created by Vladislav Falzan.
 */
class ManagerProvider {

    companion object {
        fun provide() = OpenWeatherManager()
    }
}