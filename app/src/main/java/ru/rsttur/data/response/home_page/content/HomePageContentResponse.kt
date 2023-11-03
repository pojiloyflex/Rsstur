package ru.rsttur.data.response.home_page.content

import com.squareup.moshi.Json

data class HomePageContentResponse(
    @Json(name = "title") val title: String,
    @Json(name = "template") val template: HomePageTemplateResponse,
    @Json(name = "url") val url: String
)
