package ru.rsttur.data.response

import com.squareup.moshi.Json
import ru.rsttur.data.response.error.BackendError


open class BaseResponse(
    @Json( name = "success") open val success: Boolean,
    @Json( name = "error") open val error: BackendError?,
    @Json( name = "time") open val time: String
)
