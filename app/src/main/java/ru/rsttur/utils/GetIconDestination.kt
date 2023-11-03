package ru.rsttur.utils

import ru.rsttur.R


fun getIconDestination(iconUrl: String): Int = when (iconUrl) {
    "rst-play-circle" -> R.drawable.rst_play_circle
    "rst-map_marker_path" -> R.drawable.rst_map_marker_path
    "rst-weather-sunny" -> R.drawable.rst_weather_sunny
    "rst-help" -> R.drawable.rst_help
    else -> R.drawable.rst_weather_cloudy
}