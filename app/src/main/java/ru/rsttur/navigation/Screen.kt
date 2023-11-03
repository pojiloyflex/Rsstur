package ru.rsttur.navigation

sealed class Screen(val route: String, val title: String, val id: String){
    object HomePage : Screen("home", "Главная", "")
    object Blog: Screen("blog", "Блог",  "blodId")
}
