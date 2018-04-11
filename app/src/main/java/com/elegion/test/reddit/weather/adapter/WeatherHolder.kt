package com.elegion.test.reddit.weather.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.elegion.test.reddit.model.Weather
import kotlinx.android.synthetic.main.li_weather.view.*

/**
 * Created by Vladislav Falzan.
 */
class WeatherHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Weather) = with(itemView) {
        city_name.text = item.mCityName
        temperature.text = item.mTemperatureObject.mTemperature.toString()
        humidity.text = item.mTemperatureObject.mHumidity.toString()
    }
}