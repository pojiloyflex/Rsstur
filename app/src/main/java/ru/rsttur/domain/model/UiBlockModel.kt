package ru.rsttur.domain.model

import ru.rsttur.utils.CardType
import ru.rsttur.utils.Direction


data class UiBlockModel(
    val title: String = "",
    val direction: Direction,
    val cardType: CardType,
    val items: List<UiComponent>
)