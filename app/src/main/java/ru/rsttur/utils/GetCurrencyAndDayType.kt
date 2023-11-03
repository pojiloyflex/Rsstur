package ru.rsttur.utils

fun getCurrencySymbol(currency: String) = when (currency) {
    "RUB" -> "₽"
    else -> ""
}

fun getTypeOfDay(type: String) = when (type) {
    "night" -> "ночь"
    "day" -> "день"
    else -> ""
}
