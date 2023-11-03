package ru.rsttur.ui.screens.blog

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.rsttur.domain.usecases.GetBlog
import ru.rsttur.ui.base.BaseViewModel
import ru.rsttur.utils.DataState
import ru.rsttur.utils.ScreenState
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(private val getBlogUseCase: GetBlog) :
    BaseViewModel<BlogState, BlogEffect>(BlogState()) {

    fun getBlog(id: Long, blogId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            getBlogUseCase(id, blogId).collect { blog ->
                when (blog) {
                    is DataState.Loading -> {
                        setState { copy(screenState = ScreenState.LOADING) }
                    }

                    is DataState.Success -> {
                        setState { copy(blog = blog.data, screenState = ScreenState.UPLOADED) }
                    }

                    is DataState.Error -> {
                        setState {
                            copy(
                                screenState = ScreenState.ERROR
                            )
                        }
                    }

                }
            }
        }
    }
}