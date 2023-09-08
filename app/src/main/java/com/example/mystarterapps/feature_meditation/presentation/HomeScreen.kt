package com.example.mystarterapps.feature_meditation.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mystarterapps.R
import com.example.mystarterapps.feature_meditation.domain.model.BottomMenuContent
import com.example.mystarterapps.feature_meditation.domain.model.Feature
import com.example.mystarterapps.feature_meditation.presentation.components.BottomMenu
import com.example.mystarterapps.feature_meditation.presentation.components.ChipSection
import com.example.mystarterapps.feature_meditation.presentation.components.CurrentMeditation
import com.example.mystarterapps.feature_meditation.presentation.components.FeatureSection
import com.example.mystarterapps.feature_meditation.presentation.components.GreetingSection
import com.example.mystarterapps.feature_meditation.ui.theme.Beige1
import com.example.mystarterapps.feature_meditation.ui.theme.Beige2
import com.example.mystarterapps.feature_meditation.ui.theme.Beige3
import com.example.mystarterapps.feature_meditation.ui.theme.BlueViolet1
import com.example.mystarterapps.feature_meditation.ui.theme.BlueViolet2
import com.example.mystarterapps.feature_meditation.ui.theme.BlueViolet3
import com.example.mystarterapps.feature_meditation.ui.theme.DeepBlue
import com.example.mystarterapps.feature_meditation.ui.theme.LightGreen1
import com.example.mystarterapps.feature_meditation.ui.theme.LightGreen2
import com.example.mystarterapps.feature_meditation.ui.theme.LightGreen3
import com.example.mystarterapps.feature_meditation.ui.theme.OrangeYellow1
import com.example.mystarterapps.feature_meditation.ui.theme.OrangeYellow2
import com.example.mystarterapps.feature_meditation.ui.theme.OrangeYellow3

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Meditate", R.drawable.ic_bubble),
            BottomMenuContent("Sleep", R.drawable.ic_moon),
            BottomMenuContent("Music", R.drawable.ic_music),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}
