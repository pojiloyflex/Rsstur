package ru.rsttur.ui.screens.blog

import ru.rsttur.domain.model.Blog
import ru.rsttur.utils.ScreenState

data class BlogState(
    val screenState: ScreenState = ScreenState.LOADING,
    val blog: Blog? = null,
)
