package com.example.mystarterapps.feature_destination_navigation.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mystarterapps.feature_destination_navigation.presentation.destinations.ProfileScreenDestination
import com.example.mystarterapps.feature_room.data.JournalEntry
import com.example.mystarterapps.core.util.DateUtil
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

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
            navigator.navigate(
                ProfileScreenDestination(
                    JournalEntry(
                        id = 99,
                        mood = "example_mood",
                        note = "example_note",
                        date = DateUtil().getCurrentDate()
                    )
                )
            )
        }) {
            Text("Go to Profile Screen")
        }
    }
}
