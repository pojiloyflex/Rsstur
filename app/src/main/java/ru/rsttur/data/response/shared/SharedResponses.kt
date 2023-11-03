package ru.rsttur.data.response.shared

import com.squareup.moshi.Json

data class ImageResponse(
    @Json(name = "sm") val sm: String,
    @Json(name = "md") val md: String,
    @Json(name = "lg") val lg: String
)

data class DateResponse(
    @Json(name = "typeDate") val typeDate: String,
    @Json(name = "date") val date: String?,
)

data class DurationResponse(
    @Json(name = "day") val day: Int?,
    @Json(name = "night") val night: Int?
)

data class PriceResponse(
    @Json(name = "factPrice") val factPrice: Int,
    @Json(name = "price") val price: Int,
    @Json(name = "currency") val currency: String,
    @Json(name = "typePrice") val typePrice: String
)

data class HomeResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "type") val type: String,
    @Json(name = "night") val night: Int,
    @Json(name = "url") val url: String,
    @Json(name = "image") val image: ImageResponse,
    @Json(name = "base") val base: Base
)

data class Base(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String
)