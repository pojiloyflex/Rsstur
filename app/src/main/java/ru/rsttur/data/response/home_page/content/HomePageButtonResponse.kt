package ru.rsttur.data.response.home_page.content

import com.squareup.moshi.Json


data class HomePageButtonResponse(
    @Json(name = "icon") val icon: String,
    @Json(name = "color") val color: String,
    @Json(name = "title") val title: String,
    @Json(name = "type") val type: String,
    @Json(name = "url") val url: String
)

