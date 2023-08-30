package com.example.mystarterapps.feature_landing_page

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mystarterapps.feature_cryptocurency_app.presentation.CryptocurrencyApp
import com.example.mystarterapps.feature_cryptocurency_app.presentation.ui.theme.CryptocurrencyAppYTTheme
import com.example.mystarterapps.feature_dictionary.DictionaryApp
import com.example.mystarterapps.feature_landing_page.presentation.LandingPageScreen

@Composable
fun LandingPageApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "landing_page"
    ) {
        composable("landing_page") {
            LandingPageScreen(navController)
        }
        composable("dictionary") {
            DictionaryApp()
        }
        composable("cryptocurrency") {
            CryptocurrencyAppYTTheme {
                CryptocurrencyApp()
            }
        }
    }
}