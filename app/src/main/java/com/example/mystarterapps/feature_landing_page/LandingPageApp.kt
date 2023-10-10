package com.example.mystarterapps.feature_landing_page

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mystarterapps.feature_calculator.CalculatorApp
import com.example.mystarterapps.feature_cryptocurrency.CryptocurrencyApp
import com.example.mystarterapps.feature_dictionary.DictionaryApp
import com.example.mystarterapps.feature_image_swiper.presentation.ImageSwiperApp
import com.example.mystarterapps.feature_landing_page.presentation.LandingPageScreen
import com.example.mystarterapps.feature_meditation.MeditationApp
import com.example.mystarterapps.feature_note.NoteApp
import com.example.mystarterapps.feature_stock_market.StockMarketApp
import com.example.mystarterapps.feature_timer.TimerApp
import com.example.mystarterapps.feature_todo_list.TodoApp
import com.example.mystarterapps.feature_weather.WeatherApp
import com.example.mystarterapps.feature_weather.presentation.weather.WeatherViewModel

@Composable
fun LandingPageApp(
    viewModel: WeatherViewModel,
) {
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
            CryptocurrencyApp()
        }
        composable("calculator") {
            CalculatorApp()
        }
        composable("image swiper") {
            ImageSwiperApp()
        }
        composable("meditation") {
            MeditationApp()
        }
        composable("note") {
            NoteApp()
        }
        composable("stock market") {
            StockMarketApp()
        }
        composable("timer") {
            TimerApp()
        }
        composable("todo list") {
            TodoApp()
        }
        composable("weather") {
            WeatherApp(viewModel)
        }
    }
}