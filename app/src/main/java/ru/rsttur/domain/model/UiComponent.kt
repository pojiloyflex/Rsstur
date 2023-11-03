package ru.rsttur.domain.model

sealed interface UiComponent {
    class Button(val color: String, val title: String, val icon: String) : UiComponent
    data class BlogPreview(
        val id: Long,
        val title: String,
        val subtitle: String,
        val likes: Int,
        val view: Int,
        val imageLink: String
    ) : UiComponent

    data class Card(val imageLink: String, val title: String, val subtitle: String) : UiComponent
    data class Tour(
        val title: String,
        val imageLink: String,
        val date: String,
        val durationDay: Int,
        val durationNight: Int,
        val price: Int,
        val currency: String,
        val home: String,
        val houseName: String,
    ) : UiComponent

    data class Room(
        val title: String,
        val imageLink: String,
        val duration: Int,
        val currency: String,
        val touristNumber: Int,
        val typePrice: String,
        val price: Int
    ) : UiComponent
}
