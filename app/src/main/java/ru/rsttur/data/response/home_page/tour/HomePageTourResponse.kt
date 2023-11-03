package ru.rsttur.data.response.home_page.tour

import com.squareup.moshi.Json
import ru.rsttur.data.response.BaseResponse
import ru.rsttur.data.response.error.BackendError
import ru.rsttur.data.response.shared.DateResponse
import ru.rsttur.data.response.shared.DurationResponse
import ru.rsttur.data.response.shared.HomeResponse
import ru.rsttur.data.response.shared.ImageResponse
import ru.rsttur.data.response.shared.PriceResponse
import ru.rsttur.domain.model.UiComponent
import ru.rsttur.domain.model.UiModelConvertible

data class HomePageTourResponse(
    @Json(name = "success") override val success: Boolean,
    @Json(name = "error") override val error: BackendError?,
    @Json(name = "time") override val time: String,
    @Json(name = "data") val data: List<HomePageTourData>
): BaseResponse(success, error, time)

data class HomePageTourData(
    @Json(name = "id") val id: Int,
    @Json(name = "url") val url: String,
    @Json(name = "image") val image: ImageResponse,
    @Json(name = "title") val title: String,
    @Json(name = "location") val location: String,
    @Json(name = "date") val date: DateResponse,
    @Json(name = "duration") val duration: DurationResponse,
    @Json(name = "price") val price: PriceResponse,
    @Json(name = "home") val home: HomeResponse
): UiModelConvertible {
    override fun toUiModel() =  UiComponent.Tour(
        imageLink = image.md,
        durationDay = duration.day ?: 0,
        durationNight = duration.night ?: 0,
        title = title,
        price = price.price,
        currency = price.currency,
        date = date.date ?: "",
        houseName = home.name,
        home = home.type
    )
}