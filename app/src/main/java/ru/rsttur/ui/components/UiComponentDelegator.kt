package ru.rsttur.ui.components

import androidx.compose.runtime.Composable
import ru.rsttur.domain.model.UiComponent
import ru.rsttur.utils.CardType

@Composable
fun UiComponentDelegator(component: UiComponent, cardType: CardType, onBlogClicked: (Long, String) -> Unit) {
    when (component) {
        is UiComponent.BlogPreview -> {
            BlogPreviewCard(
                id = component.id,
                url = component.imageLink,
                title = component.title,
                subtitle = component.subtitle,
                views = component.view,
                likes = component.likes,
                onBlogClicked = onBlogClicked
            )
        }

        is UiComponent.Button -> {
            GradientButton(title = component.title, icon = component.icon, color = component.color)
        }

        is UiComponent.Card -> {
            BaseCard(
                url = component.imageLink,
                title = component.title,
                subtitle = component.subtitle,
                cardType = cardType
            )
        }

        is UiComponent.Room -> {
            RoomCard(
                url = component.imageLink,
                title = component.title,
                touristCount = component.touristNumber,
                price = component.price,
                currency = component.currency,
                dayType = component.typePrice
            )
        }

        is UiComponent.Tour -> {
            TourCard(
                title = component.title,
                imageLink = component.imageLink,
                date = component.date,
                durationDay = component.durationDay,
                durationNight = component.durationNight,
                price = component.price,
                home = component.home,
                houseName = component.houseName,
                currency = component.currency
            )

        }
    }
}