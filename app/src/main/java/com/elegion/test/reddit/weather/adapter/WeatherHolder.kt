package com.elegion.test.reddit.weather.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.elegion.test.reddit.common.BaseWeatherModel
import kotlinx.android.synthetic.main.li_weather.view.*

/**
 * Created by Vladislav Falzan.
 */
class WeatherHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: BaseWeatherModel) = with(itemView) {
        city_name.text = item.mName
        temperature.text = item.mTemperature.toString()
        humidity.text = item.mHumidity.toString()
    }
}