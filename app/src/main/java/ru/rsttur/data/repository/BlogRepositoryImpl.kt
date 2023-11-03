package ru.rsttur.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.rsttur.data.mapper.toBlog
import ru.rsttur.data.source.remote.ApiConstants.ERROR_MESSAGE
import ru.rsttur.data.source.remote.ApiService
import ru.rsttur.domain.model.Blog
import ru.rsttur.domain.repository.BlogRepository
import ru.rsttur.utils.DataState
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(private val apiService: ApiService) : BlogRepository {
    override suspend fun getBlog(id: Long, blogId: Long): Flow<DataState<Blog>> = flow {
        emit(DataState.Loading)
        try {
            val blog = apiService.getBlog(id, blogId).data.toBlog()
            emit(DataState.Success(blog))
        } catch (exception: Exception) {
            Log.d("RSSTUR_ERROR", "${exception.message} \n ${exception.cause} \n ${exception.stackTrace}")
            emit(DataState.Error(ERROR_MESSAGE))
        }
    }
}