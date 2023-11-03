package ru.rsttur.data.response.blog

import com.squareup.moshi.Json
import ru.rsttur.data.response.shared.ImageResponse

data class BlogItemResponse(
    @Json(name= "id")val id: Int,
    @Json(name= "url")val url: String,
    @Json(name= "image")val image: ImageResponse,
    @Json(name= "title")val title: String,
    @Json(name= "subtitle")val subtitle: String,
    @Json(name= "like")val like: Int,
    @Json(name= "date")val date: String,
    @Json(name= "content")val content: String
)