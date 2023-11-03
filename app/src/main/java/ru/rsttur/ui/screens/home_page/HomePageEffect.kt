package ru.rsttur.ui.screens.home_page

sealed interface HomePageEffect {
    class NavigateToBlog(val title: String, val blogId: Long): HomePageEffect
}