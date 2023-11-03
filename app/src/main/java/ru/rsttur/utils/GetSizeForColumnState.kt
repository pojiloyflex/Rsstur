package ru.rsttur.utils

fun getCellNumbers(value: String): Int {
    return if (value == "Питание") 2 else 1
}

const val MIN_DISPLAYED_ELEMENTS = 6
fun getSizeForExpandedState(size: Int) =
    if (size < MIN_DISPLAYED_ELEMENTS) size else MIN_DISPLAYED_ELEMENTS

fun getSizeForInitialState(initialSize: Int, currentSize: Int) =
    if (initialSize == currentSize) MIN_DISPLAYED_ELEMENTS else currentSize