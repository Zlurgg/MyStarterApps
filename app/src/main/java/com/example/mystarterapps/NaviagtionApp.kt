package com.example.mystarterapps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.mystarterapps.data.Entry
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.time.LocalDateTime

@Composable
fun NavigationApp() {
    @Destination(start = true)
    @Composable
    fun LoginScreen(
        navigator: DestinationsNavigator
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Login Screen")
            Button(onClick = {
//                navigator.navigate(
//                    ProfileScreenDestination(
//                        Entry(
//                            id = 99,
//                            mood = "good",
//                            note = "happy",
//                            date = LocalDateTime.now().toString(),
//                        )
//                    )
//                )
            }) {
                Text("Go to Profile Screen")
            }
        }
    }

    @Destination
    @Composable
    fun ProfileScreen(
        navigator: DestinationsNavigator,
        entry: Entry
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Profile Screen: $entry", textAlign = TextAlign.Center)
            Button(onClick = {
//                navigator.navigate(
//                    ProfileScreenDestination()
//                )
            }) {
                Text("Go to Post Screen")
            }
        }
    }

    @Destination
    @Composable
    fun PostScreen(
        showOnlyPostsByUser: Boolean = false
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Post Screen, $showOnlyPostsByUser")
        }
    }
}