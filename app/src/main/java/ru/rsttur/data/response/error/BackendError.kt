package ru.rsttur.data.response.error

import com.squareup.moshi.Json

data class BackendError(
    @Json( name = "name") val name: String,
    @Json( name = "status") val status: String,
    @Json( name = "code") val code: String,
    @Json( name = "message") val message: String
)