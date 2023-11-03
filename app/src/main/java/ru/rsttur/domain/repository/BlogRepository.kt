package ru.rsttur.domain.repository

interface BlogRepository {
    suspend fun getBlog()
}