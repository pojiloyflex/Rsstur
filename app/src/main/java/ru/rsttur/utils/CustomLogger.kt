package ru.rsttur.utils

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

class CustomHttpLogger : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Log.d(CustomHttpLogger::class.simpleName, message)
    }
}