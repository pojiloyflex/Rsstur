package ru.rsttur.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.rsttur.domain.model.UiBlockModel
import ru.rsttur.utils.DataState

interface HomePageRepository {
    suspend fun getHomePage(): Flow<DataState<List<UiBlockModel>>>
}