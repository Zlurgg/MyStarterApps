package com.example.mystarterapps.feature_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mystarterapps.feature_dagger_hilt_vm.presentation.MyViewModel
import com.example.mystarterapps.ui.theme.MyStarterAppsTheme
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStarterAppsTheme {
                RoomApp()
            }
        }
    }
}


