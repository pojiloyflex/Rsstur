package ru.rsttur.data.mapper

import ru.rsttur.data.response.blog.BlogItemResponse
import ru.rsttur.domain.model.Blog

fun BlogItemResponse.toBlog() = Blog(
    link = image.lg,
    date = date,
    title = title,
    content = content
)