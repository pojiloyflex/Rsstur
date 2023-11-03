package ru.rsttur.data.response.blog

import com.squareup.moshi.Json
import ru.rsttur.data.response.BaseResponse
import ru.rsttur.data.response.error.BackendError

data class BlogResponse(
    @Json(name = "data") val data: BlogItemResponse,
    @Json(name = "success") override val success: Boolean,
    @Json(name = "error") override val error: BackendError?,
    @Json(name = "time") override val time: String,
): BaseResponse(success, error, time)