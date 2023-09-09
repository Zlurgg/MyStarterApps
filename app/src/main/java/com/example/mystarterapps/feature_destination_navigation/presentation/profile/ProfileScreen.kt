package com.example.mystarterapps.feature_destination_navigation.presentation.profile
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.style.TextAlign
//import com.example.mystarterapps.feature_destination_navigation.presentation.destinations.PostScreenDestination
//import com.example.mystarterapps.feature_room.data.JournalEntry
//import com.ramcosta.composedestinations.annotation.Destination
//import com.ramcosta.composedestinations.navigation.DestinationsNavigator
//
//@Destination()
//@Composable
//fun ProfileScreen(
//    navigator: DestinationsNavigator,
//    journalEntry: JournalEntry
//) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Profile Screen: ${journalEntry.mood}", textAlign = TextAlign.Center)
//
//        Button(onClick = {
//            navigator.navigate(PostScreenDestination())
//        }) {
//            Text("Go to Post Screen")
//        }
//    }
//}