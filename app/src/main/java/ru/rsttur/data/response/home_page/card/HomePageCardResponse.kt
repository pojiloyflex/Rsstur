package ru.rsttur.data.response.home_page.card

import com.squareup.moshi.Json
import ru.rsttur.data.response.BaseResponse
import ru.rsttur.data.response.error.BackendError
import ru.rsttur.data.response.shared.ImageResponse
import ru.rsttur.domain.model.UiComponent
import ru.rsttur.domain.model.UiModelConvertible

data class HomePageCardResponse(
    @Json(name = "data") val data: List<HomePageCardData>,
    @Json(name = "success") override val success: Boolean,
    @Json(name = "error") override val error: BackendError?,
    @Json(name = "time") override val time: String,
): BaseResponse(success, error, time)

data class HomePageCardData(
    @Json(name = "id") val id: Int,
    @Json(name = "image") val image: ImageResponse,
    @Json(name = "title") val title: String,
    @Json(name = "subtitle") val subtitle: String
): UiModelConvertible {
    override fun toUiModel() = UiComponent.Card(
        title = title,
        imageLink = image.md,
        subtitle = subtitle
    )
}