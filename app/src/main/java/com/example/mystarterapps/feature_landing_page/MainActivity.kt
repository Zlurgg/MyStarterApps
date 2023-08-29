package com.example.mystarterapps.feature_landing_page

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import com.example.mystarterapps.feature_cryptocurency_app.presentation.CryptocurrencyApp
import com.example.mystarterapps.feature_cryptocurency_app.presentation.ui.theme.CryptocurrencyAppYTTheme
import com.example.mystarterapps.feature_dictionary.DictionaryApp
import com.example.mystarterapps.ui.theme.MyStarterAppsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            CryptocurrencyAppYTTheme {
//                CryptocurrencyApp()
//            }
            MyStarterAppsTheme {
                DictionaryApp()
            }
        }
    }
}