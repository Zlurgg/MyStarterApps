package com.example.mystarterapps.feature_cryptocurency_app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mystarterapps.feature_cryptocurency_app.presentation.Screen
import com.example.mystarterapps.feature_cryptocurency_app.presentation.coin_detail.CoinDetailScreen
import com.example.mystarterapps.feature_cryptocurency_app.presentation.coin_list.CoinListScreen
import com.example.mystarterapps.feature_cryptocurency_app.presentation.ui.theme.CryptocurrencyAppTheme

@Composable
fun CryptocurrencyApp(
) {
    CryptocurrencyAppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.CoinListScreen.route
            ) {
                composable(
                    route = Screen.CoinListScreen.route
                ) {
                    CoinListScreen(navController)
                }
                composable(
                    route = Screen.CoinDetailScreen.route + "/{coinId}"
                ) {
                    CoinDetailScreen()
                }
            }
        }
    }
}