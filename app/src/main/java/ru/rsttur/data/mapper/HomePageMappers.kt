package ru.rsttur.data.mapper

import ru.rsttur.data.response.home_page.content.HomePageButtonResponse
import ru.rsttur.data.response.home_page.content.HomePageContentResponse
import ru.rsttur.domain.model.UiBlockModel
import ru.rsttur.domain.model.UiComponent
import ru.rsttur.domain.model.UiModelConvertible
import ru.rsttur.utils.CardType
import ru.rsttur.utils.Direction
import kotlin.reflect.KSuspendFunction1


fun HomePageButtonResponse.toButtonContentUiModel() = UiComponent.Button(
    title = title,
    color = color,
    icon = icon
)

fun <T : UiModelConvertible> List<T>.toListUiModel(): List<UiComponent> {
    return this.map { it.toUiModel() }
}

fun List<HomePageButtonResponse>.toUiBlockModel(): UiBlockModel {
    val buttons = this.map { it.toButtonContentUiModel() }
    return UiBlockModel(
        title = "",
        direction = Direction.HORIZONTAL,
        cardType = CardType.HORIZONTAL,
        items = buttons
    )
}

fun HomePageContentResponse.toUiBlockModel(list: List<UiComponent>) = UiBlockModel(
    title = title,
    direction = getDirection(template.direction),
    cardType = getCardType(template.card),
    items = list
)

suspend fun List<HomePageContentResponse>.toUiBlockModel(getDataAccordingToType: KSuspendFunction1<String, List<UiComponent>>): List<UiBlockModel> {
    return this.map { it.toUiBlockModel(getDataAccordingToType(it.url)) }
}

fun getDirection(value: String): Direction {
    return try {
        Direction.valueOf(value.uppercase())
    } catch (e: IllegalArgumentException) {
        Direction.HORIZONTAL
    }
}

fun getCardType(value: String): CardType {
    return try {
        CardType.valueOf(value.uppercase())
    } catch (e: IllegalArgumentException) {
        CardType.HORIZONTAL
    }
}