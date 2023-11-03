package ru.rsttur.data.response.home_page.blog_preview

import com.squareup.moshi.Json
import ru.rsttur.data.response.shared.DateResponse
import ru.rsttur.data.response.shared.ImageResponse
import ru.rsttur.domain.model.UiComponent
import ru.rsttur.domain.model.UiModelConvertible

data class HomePageBlogPostResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "image") val image: ImageResponse,
    @Json(name = "title") val title: String,
    @Json(name = "subtitle") val subtitle: String,
    @Json(name = "view") val view: Int,
    @Json(name = "like") val like: Int,
    @Json(name = "date") val date: DateResponse
) : UiModelConvertible {
    override fun toUiModel() = UiComponent.BlogPreview(
        id = id,
        title = title,
        subtitle = subtitle,
        likes = like,
        view = view,
        imageLink = image.md
    )
}