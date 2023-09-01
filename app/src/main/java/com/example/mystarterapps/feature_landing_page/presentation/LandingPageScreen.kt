package com.example.mystarterapps.feature_landing_page.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mystarterapps.feature_landing_page.presentation.component.AppToRunButton

@Composable
fun LandingPageScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Choose an App to run",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.SemiBold
            )
            AppToRunButton(navController = navController, appName = "Calculator")
            AppToRunButton(navController = navController, appName = "Cryptocurrency")
            AppToRunButton(navController = navController, appName = "Dictionary")
            AppToRunButton(navController = navController, appName = "Meditation")
            AppToRunButton(navController = navController, appName = "Note")
            AppToRunButton(navController = navController, appName = "Timer")
        }
    }
}