package ru.rsttur.ui.screens.blog

sealed interface BlogEffect {
    object NavigateToHomePage: BlogEffect
}