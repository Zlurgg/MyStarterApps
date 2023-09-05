package com.example.mystarterapps.feature_landing_page

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mystarterapps.feature_calculator.CalculatorApp
import com.example.mystarterapps.feature_cryptocurency_app.CryptocurrencyApp
import com.example.mystarterapps.feature_dictionary.DictionaryApp
import com.example.mystarterapps.feature_landing_page.presentation.LandingPageScreen
import com.example.mystarterapps.feature_meditation.MeditationApp
import com.example.mystarterapps.feature_note.NoteApp
import com.example.mystarterapps.feature_timer.TimerApp
import com.example.mystarterapps.feature_weather.WeatherApp
import com.example.mystarterapps.feature_weather.presentation.weather.WeatherViewModel

@Composable
fun LandingPageApp(
    viewModel: WeatherViewModel,
) {
    val navController = rememberNavController()

/*    val apps =
        listOf(
            Pair(DictionaryApp(),"dictionary" ),
            Pair(CryptocurrencyApp(),"cryptocurrency" ),
            Pair(CalculatorApp(),"calculator" ),
            Pair(MeditationApp(),"meditation" ),
            Pair(NoteApp(),"note" ),
            Pair(TimerApp(),"timer" ),
            Pair(WeatherApp(),"weather"),
        )*/

    NavHost(
        navController = navController,
        startDestination = "landing_page"
    ) {
        composable("landing_page") {
            LandingPageScreen(navController)
        }
//        apps.forEach { v ->
//            println(v.first)
//            composable(v.second) {
//                v.first
//            }
//        }
        composable("dictionary") {
            DictionaryApp()
        }
        composable("cryptocurrency") {
            CryptocurrencyApp()
        }
        composable("calculator") {
            CalculatorApp()
        }
        composable("meditation") {
            MeditationApp()
        }
        composable("note") {
            NoteApp()
        }
        composable("timer") {
            TimerApp()
        }
        composable("weather") {
            WeatherApp(viewModel)
        }
    }
}