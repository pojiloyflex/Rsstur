package ru.rsttur.utils

sealed class DataState<out T : Any> {
    object Loading : DataState<Nothing>()
    data class Success<out T : Any>(val data: T) : DataState<T>()
    data class Error(val errorMessage: String) : DataState<Nothing>()
}