package ru.rsttur.ui.screens.home_page

import ru.rsttur.domain.model.UiBlockModel
import ru.rsttur.utils.ScreenState

data class HomePageState(
    val screenState: ScreenState = ScreenState.LOADING,
    val uiBlocks: List<UiBlockModel> = listOf(),
)
