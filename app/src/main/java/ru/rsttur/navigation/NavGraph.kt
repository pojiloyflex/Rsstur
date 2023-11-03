package ru.rsttur.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.rsttur.ui.screens.blog.BlogContent
import ru.rsttur.ui.screens.home_page.HomePageContent

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomePage.route) {
        composable(Screen.HomePage.route) {
            HomePageContent(navController, Screen.HomePage.title)
        }
        composable(
            route = "${Screen.Blog.route}/{${Screen.Blog.title}}/{${Screen.Blog.id}}",
            arguments = listOf(
                navArgument(Screen.Blog.title) { type = NavType.StringType },
                navArgument(Screen.Blog.id) { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString(Screen.Blog.title) ?: ""
            val id = backStackEntry.arguments?.getLong(Screen.Blog.id) ?: 0
            BlogContent(navController, title, id)
        }
    }
}