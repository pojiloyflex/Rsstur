package ru.rsttur.data.response.home_page.room

import com.squareup.moshi.Json
import ru.rsttur.data.response.BaseResponse
import ru.rsttur.data.response.error.BackendError
import ru.rsttur.data.response.shared.DateResponse
import ru.rsttur.data.response.shared.DurationResponse
import ru.rsttur.data.response.shared.ImageResponse
import ru.rsttur.data.response.shared.PriceResponse
import ru.rsttur.domain.model.UiComponent
import ru.rsttur.domain.model.UiModelConvertible

data class HomePageRoomResponse(
    @Json(name = "success") override val success: Boolean,
    @Json(name = "error") override val error: BackendError?,
    @Json(name = "time") override val time: String,
    @Json(name = "data") val data: List<HomePageRoomData>
):BaseResponse(success, error, time)

data class HomePageRoomData(
    @Json(name = "id") val id: Int,
    @Json(name = "image") val image: ImageResponse,
    @Json(name = "title") val title: String,
    @Json(name = "date") val date: DateResponse,
    @Json(name = "duration") val duration: DurationResponse,
    @Json(name = "price") val price: PriceResponse,
    @Json(name = "countTourist") val countTourist: Int,
    @Json(name = "type") val type: String
): UiModelConvertible {
    override fun toUiModel() = UiComponent.Room(
        imageLink = image.md,
        title = title,
        duration = duration.night ?: 0,
        price = price.factPrice,
        typePrice = price.typePrice,
        currency = price.currency,
        touristNumber = countTourist
    )
}