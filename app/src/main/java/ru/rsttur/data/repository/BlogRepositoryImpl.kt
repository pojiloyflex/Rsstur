package ru.rsttur.data.repository

import ru.rsttur.data.source.remote.ApiService
import ru.rsttur.domain.repository.BlogRepository
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(apiService: ApiService) : BlogRepository {
    override suspend fun getBlog() {

    }
}