package com.example.mystarterapps

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mystarterapps.ui.EntryScreen

@Composable
fun RoomApp() {
    /** old style nav **/
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "mood"
    ) {
        composable("mood") {
            EntryScreen(navController)
        }
    }
}

