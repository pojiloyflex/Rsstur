package ru.rsttur.data.response.home_page.content

import com.squareup.moshi.Json


data class HomePageTemplateResponse(
    @Json(name = "card") val card: String,
    @Json(name = "object") val obj: String,
    @Json(name = "size") val size: String,
    @Json(name = "direction") val direction: String
)
