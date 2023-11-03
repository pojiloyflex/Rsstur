package ru.rsttur.utils

const val MIN_DISPLAYED_ELEMENTS_IN_ROW = 2

fun getTextForButton(currentSize: Int, actualSize: Int) = if(currentSize != actualSize) "Показать все (${actualSize - MIN_DISPLAYED_ELEMENTS})" else "Свернуть"

fun getTextForRemainedItems(size: Int) = if(size > MIN_DISPLAYED_ELEMENTS_IN_ROW) "Все (${size - 2})" else ""