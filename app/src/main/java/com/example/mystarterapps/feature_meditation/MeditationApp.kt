package com.example.mystarterapps.feature_meditation

import androidx.compose.runtime.Composable
import com.example.mystarterapps.feature_meditation.presentation.ui.HomeScreen
import com.example.mystarterapps.feature_meditation.presentation.ui.theme.MeditationUIYouTubeTheme

@Composable
fun MeditationApp() {
    MeditationUIYouTubeTheme {
        HomeScreen()
    }
}

