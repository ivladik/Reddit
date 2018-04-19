package com.elegion.test.reddit.weather.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.elegion.test.reddit.R
import com.elegion.test.reddit.common.BaseWeatherModel

/**
 * Created by Vladislav Falzan.
 */
class WeatherAdapter : RecyclerView.Adapter<WeatherHolder>() {

    private var weatherList: ArrayList<BaseWeatherModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.li_weather, parent, false)
        return WeatherHolder(v)
    }

    override fun getItemCount() = weatherList.size

    override fun onBindViewHolder(holder: WeatherHolder?, position: Int) {
        val item = weatherList[position]
        holder?.bind(item)
    }

    fun addWeather(newItems: List<BaseWeatherModel>) {
        weatherList.clear()
        weatherList.addAll(newItems)
        notifyDataSetChanged()
    }
}