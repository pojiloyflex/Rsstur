package ru.rsttur.utils

import androidx.compose.ui.graphics.Color
import ru.rsttur.ui.theme.G11Start
import ru.rsttur.ui.theme.G12Start
import ru.rsttur.ui.theme.G13Start
import ru.rsttur.ui.theme.G19Start

fun getColor(value: String): Color = when (value) {
    "g-13" -> G13Start

    "g-12" ->G12Start

    "g-11" ->G11Start

    else -> G19Start
}