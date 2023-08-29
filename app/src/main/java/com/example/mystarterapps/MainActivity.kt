package com.example.mystarterapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mystarterapps.feature_landing_page.LandingPageApp
import com.example.mystarterapps.ui.theme.MyStarterAppsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStarterAppsTheme {
                LandingPageApp()
            }
        }
    }
}