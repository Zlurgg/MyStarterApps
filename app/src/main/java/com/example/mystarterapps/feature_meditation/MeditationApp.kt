package com.example.mystarterapps.feature_meditation

import androidx.compose.runtime.Composable
import com.example.mystarterapps.feature_meditation.presentation.HomeScreen
import com.example.mystarterapps.feature_meditation.ui.theme.MeditationUITheme

@Composable
fun MeditationApp() {
    MeditationUITheme {
        HomeScreen()
    }
}

