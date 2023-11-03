package ru.rsttur.utils

import java.net.URL

fun parseUrl(url: String): List<String> {
    val urlObj = URL(url)
    return urlObj.query.split("&").mapNotNull { it.split("=").getOrNull(1) }
}
