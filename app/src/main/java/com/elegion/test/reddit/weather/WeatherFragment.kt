package com.elegion.test.reddit.weather

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elegion.test.reddit.common.BaseFragment
import com.elegion.test.reddit.R
import com.elegion.test.reddit.api.ManagerProvider
import com.elegion.test.reddit.weather.adapter.WeatherAdapter
import com.elegion.test.reddit.extensions.inflate
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fr_weather.*

/**
 * Created by Vladislav Falzan.
 */
class WeatherFragment : BaseFragment() {

    private val mWeatherManager = ManagerProvider.provide()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fr_weather)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        weather_list.setHasFixedSize(true)
        weather_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
        }
    }

    private fun requestNews() {
        val disposable = mWeatherManager.getWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { weatherList ->
                            (weather_list.adapter as WeatherAdapter).addWeather(weatherList)
                        },
                        { error ->
                            Snackbar.make(
                                    weather_list,
                                    error.message ?: "",
                                    Snackbar.LENGTH_LONG
                            )
                                    .show()
                        }
                )
        mCompositeDisposable.add(disposable)
    }

    private fun initAdapter() {
        if (weather_list.adapter == null) {
            weather_list.adapter = WeatherAdapter()
        }
    }
}