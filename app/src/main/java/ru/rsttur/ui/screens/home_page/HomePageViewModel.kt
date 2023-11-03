package ru.rsttur.ui.screens.home_page

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.rsttur.domain.usecases.GetHomePage
import ru.rsttur.ui.base.BaseViewModel
import ru.rsttur.utils.DataState
import ru.rsttur.utils.ScreenState
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel
@Inject constructor(private val getHomePageUseCase: GetHomePage) :
    BaseViewModel<HomePageState, HomePageEffect>(HomePageState()) {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            getHomePageUseCase().collect { result ->
                when (result) {
                    is DataState.Success -> setState {
                        copy(
                            uiBlocks = result.data,
                            screenState = ScreenState.UPLOADED
                        )
                    }
                    is DataState.Loading -> setState { copy(screenState = ScreenState.LOADING) }
                    is DataState.Error -> setState { copy(screenState = ScreenState.ERROR) }
                }
            }
        }
    }

    fun onBlogPreviewClicked(id: Long, title: String) {
        postEffect(HomePageEffect.NavigateToBlog(title, id))
    }
}
