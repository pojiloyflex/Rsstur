package ru.rsttur.ui.screens.blog

import BaseImage
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.rsttur.data.source.remote.DEFAULT_ID
import ru.rsttur.domain.model.Blog
import ru.rsttur.ui.components.ErrorContent
import ru.rsttur.ui.components.LoadingContent
import ru.rsttur.utils.ScreenState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogContent(navController: NavController, title: String, id: Long) {
    val blogViewModel = hiltViewModel<BlogViewModel>()
    val state = blogViewModel.state.collectAsState()
    blogViewModel.getBlog(DEFAULT_ID, id)
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Content(state.value.screenState == ScreenState.UPLOADED, state.value.blog)
            LoadingContent(state.value.screenState == ScreenState.LOADING)
            ErrorContent(state.value.screenState == ScreenState.ERROR)
        }
    }
}

@Composable
fun Content(isDisplayed: Boolean, blog: Blog?) {
    if (isDisplayed && blog != null) {
        BaseImage(
            url = blog.link, modifier = Modifier
                .width(500.dp)
                .height(300.dp)
        )
        Text(
            modifier = Modifier
                .padding(top = 6.dp),
            text = blog.date,
            fontWeight = FontWeight.Light,
            overflow = TextOverflow.Ellipsis,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify
        )
        Text(
            modifier = Modifier
                .padding(bottom = 6.dp),
            text = blog.title,
            fontWeight = FontWeight.ExtraBold,
            overflow = TextOverflow.Ellipsis,
            fontSize = 24.sp,
            lineHeight = 28.sp,
            textAlign = TextAlign.Justify
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = blog.content,
            fontWeight = FontWeight.Light,
            overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp,
            lineHeight = 22.sp,
            textAlign = TextAlign.Justify
        )
    }
}