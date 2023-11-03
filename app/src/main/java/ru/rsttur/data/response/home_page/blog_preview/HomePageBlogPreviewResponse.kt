package ru.rsttur.data.response.home_page.blog_preview

import com.squareup.moshi.Json
import ru.rsttur.data.response.BaseResponse
import ru.rsttur.data.response.error.BackendError


data class HomePageBlogPreviewResponse(
    @Json(name = "data") val data: List<HomePageBlogPostResponse>,
    @Json(name = "success") override val success: Boolean,
    @Json(name = "error") override val error: BackendError?,
    @Json(name = "time") override val time: String
): BaseResponse(success, error, time)
