package ru.rsttur.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.rsttur.navigation.NavGraph
import ru.rsttur.ui.theme.RstturTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RstturTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}