package ru.rsttur.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun convertDateFormat(input: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)
    val outputFormat = SimpleDateFormat("dd.MM.yyyy", Locale.US)

    val date = inputFormat.parse(input)
    return date?.let { outputFormat.format(it) } ?: ""
}