package com.example.weatherapp.repository

import com.example.weatherapp.Config
import com.example.weatherapp.api.ApiFactory
import com.example.weatherapp.content.DailyWeatherWrapper
import com.example.weatherapp.content.WeeklyWeatherWrapper
import io.reactivex.rxjava3.core.Single

object WeatherProvider {
    val weatherRepository: WeatherRepository = DefaultWeatherRepository()
}

private class DefaultWeatherRepository : WeatherRepository {

    override fun getWeatherFor10Days(cityName: String): Single<WeeklyWeatherWrapper> =
        ApiFactory.weatherService.getWeatherForSeveralDays(cityName, Config.CNT)

    override fun getCurrentWeather(cityIds: String): Single<DailyWeatherWrapper> =
        ApiFactory.weatherService.getCurrentWeatherForCities(cityIds)

}

interface WeatherRepository {

    fun getWeatherFor10Days(cityName: String): Single<WeeklyWeatherWrapper>

    fun getCurrentWeather(cityIds: String): Single<DailyWeatherWrapper>

}
