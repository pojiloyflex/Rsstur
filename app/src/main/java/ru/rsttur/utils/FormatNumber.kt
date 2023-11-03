package ru.rsttur.utils

import java.text.DecimalFormat

fun formatNumber(number: Int): String {
    val format = DecimalFormat("#,###")
    return format.format(number.toLong())
}