package ru.rsttur.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.rsttur.domain.model.Blog
import ru.rsttur.utils.DataState

interface BlogRepository {
    suspend fun getBlog(id: Long, blogId: Long) : Flow<DataState<Blog>>
}