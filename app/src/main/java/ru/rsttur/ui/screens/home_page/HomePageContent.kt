package ru.rsttur.ui.screens.home_page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.rsttur.domain.model.UiBlockModel
import ru.rsttur.domain.model.UiComponent
import ru.rsttur.navigation.Screen
import ru.rsttur.ui.components.ErrorContent
import ru.rsttur.ui.components.LoadingContent
import ru.rsttur.ui.components.UiComponentDelegator
import ru.rsttur.ui.components.VerticalGrid
import ru.rsttur.utils.Direction
import ru.rsttur.utils.MIN_DISPLAYED_ELEMENTS
import ru.rsttur.utils.ScreenState
import ru.rsttur.utils.getCellNumbers
import ru.rsttur.utils.getSizeForExpandedState
import ru.rsttur.utils.getSizeForInitialState
import ru.rsttur.utils.getTextForButton
import ru.rsttur.utils.getTextForRemainedItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageContent(navController: NavController, title: String) {
    val mainViewModel = hiltViewModel<HomePageViewModel>()
    val state = mainViewModel.state.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = CenterHorizontally
        ) {
            TopAppBar(
                title = { Text(text = title, fontWeight = FontWeight.Medium) },
            )
            Content(
                isDisplayed = state.value.screenState == ScreenState.UPLOADED,
                state.value.uiBlocks,
                onBlogClicked = mainViewModel::onBlogPreviewClicked
            )
            LoadingContent(isDisplayed = state.value.screenState == ScreenState.LOADING)
            ErrorContent(isDisplayed = state.value.screenState == ScreenState.ERROR)
            LaunchedEffect(key1 = mainViewModel.effect) {
                mainViewModel.effect.collect { effect ->
                    if (effect is HomePageEffect.NavigateToBlog) navController.navigate(
                        Screen.Blog.route.plus(
                            "/${effect.title}/${effect.blogId}"
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Content(
    isDisplayed: Boolean,
    uiBlocks: List<UiBlockModel>,
    onBlogClicked: (Long, String) -> Unit
) {
    if (isDisplayed) {
        uiBlocks.forEach { uiBlock ->
            val sizeOfUiComponents = uiBlock.items.size
            var itemsToDisplay by remember {
                mutableIntStateOf(
                    getSizeForExpandedState(
                        sizeOfUiComponents
                    )
                )
            }
            val textForButton by remember {
                derivedStateOf {
                    (getTextForButton(
                        itemsToDisplay,
                        sizeOfUiComponents
                    ))
                }
            }
            val textForRemainedItemsInRow by remember {
                derivedStateOf {
                    getTextForRemainedItems(
                        sizeOfUiComponents
                    )
                }
            }
            if (uiBlock.title.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = uiBlock.title,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 24.sp,
                    )
                    Spacer(Modifier.weight(1f))
                    if (uiBlock.direction == Direction.HORIZONTAL) {
                        Text(
                            text = textForRemainedItemsInRow,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 22.sp,
                        )
                    }
                }
            }
            when (uiBlock.direction) {
                Direction.HORIZONTAL -> {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp, horizontal = 8.dp)
                            .nestedScroll(rememberNestedScrollInteropConnection()),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        itemsIndexed(uiBlock.items) { _: Int, item: UiComponent ->
                            UiComponentDelegator(
                                component = item,
                                uiBlock.cardType,
                                onBlogClicked = onBlogClicked
                            )
                        }
                    }
                }

                Direction.VERTICAL -> {
                    VerticalGrid(
                        columns = getCellNumbers(uiBlock.title),
                        itemCount = itemsToDisplay,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        UiComponentDelegator(
                            component = uiBlock.items[it],
                            cardType = uiBlock.cardType,
                            onBlogClicked = onBlogClicked
                        )
                    }
                    if (uiBlock.items.size > MIN_DISPLAYED_ELEMENTS) {
                        OutlinedButton(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                                itemsToDisplay =
                                    getSizeForInitialState(itemsToDisplay, uiBlock.items.size)
                            }) {
                            Text(
                                modifier = Modifier.padding(vertical = 8.dp),
                                text = textForButton,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }
}