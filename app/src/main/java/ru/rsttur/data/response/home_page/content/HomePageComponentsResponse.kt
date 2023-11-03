package ru.rsttur.data.response.home_page.content

import com.squareup.moshi.Json




data class HomePageComponentsResponse(
    @Json(name = "buttons") val buttons: List<HomePageButtonResponse>,
    @Json(name = "content") val content: List<HomePageContentResponse>
)