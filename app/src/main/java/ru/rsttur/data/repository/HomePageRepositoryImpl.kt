package ru.rsttur.data.repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.rsttur.data.mapper.toListUiModel
import ru.rsttur.data.mapper.toUiBlockModel
import ru.rsttur.data.source.remote.ApiConstants.API_URL
import ru.rsttur.data.source.remote.ApiConstants.BLOGS
import ru.rsttur.data.source.remote.ApiConstants.CARDS
import ru.rsttur.data.source.remote.ApiConstants.ERROR_MESSAGE
import ru.rsttur.data.source.remote.ApiConstants.ROOMS
import ru.rsttur.data.source.remote.ApiConstants.TOURS
import ru.rsttur.data.source.remote.ApiService
import ru.rsttur.domain.model.UiBlockModel
import ru.rsttur.domain.model.UiComponent
import ru.rsttur.domain.repository.HomePageRepository
import ru.rsttur.utils.DataState
import ru.rsttur.utils.parseUrl
import javax.inject.Inject

class HomePageRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    HomePageRepository {
    override suspend fun getHomePage(): Flow<DataState<List<UiBlockModel>>> = flow {
        emit(DataState.Loading)
        try {
            val data = apiService.getHomePage().data
            val buttons = data.buttons.toUiBlockModel()
            val uiBlockModels = data.content.toUiBlockModel(::getDataAccordingToType).toMutableList()
            val contentWithButtons = mutableListOf(buttons)
            contentWithButtons.addAll(uiBlockModels)
            emit(DataState.Success(contentWithButtons))
        } catch (exception: Exception) {
            emit(DataState.Error(ERROR_MESSAGE))
        }
    }

    private suspend fun getDataAccordingToType(url: String): List<UiComponent> {
        val parameters = parseUrl(url)
        return when {
            url.startsWith(API_URL + BLOGS) -> apiService.getBlogs(parameters[0].toLong(), parameters[1]).data.toListUiModel()
            url.startsWith(API_URL + CARDS) -> apiService.getCards(parameters[0].toLong(), parameters[1]).data.toListUiModel()
            url.startsWith(API_URL +TOURS) -> apiService.getTours(parameters[0].toLong()).data.toListUiModel()
            url.startsWith(API_URL + ROOMS) -> apiService.getRooms(parameters[0].toLong()).data.toListUiModel()
            else -> listOf()
        }
    }
}
