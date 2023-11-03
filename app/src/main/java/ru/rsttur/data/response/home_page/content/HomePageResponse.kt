package ru.rsttur.data.response.home_page.content

import com.squareup.moshi.Json
import ru.rsttur.data.response.BaseResponse
import ru.rsttur.data.response.error.BackendError

data class HomePageResponse(
    @Json(name = "data") val data: HomePageComponentsResponse,
    @Json(name = "success") override val success: Boolean,
    @Json(name = "error") override val error: BackendError?,
    @Json(name = "time") override val time: String
): BaseResponse(success, error, time)
