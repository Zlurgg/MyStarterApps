package com.example.myroomsession

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myroomsession.ui.EntryScreen

@Composable
fun MyRoomSessionApp() {
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

