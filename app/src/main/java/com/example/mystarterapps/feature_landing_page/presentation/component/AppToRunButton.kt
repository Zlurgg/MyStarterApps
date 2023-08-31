package com.example.mystarterapps.feature_landing_page.presentation.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AppToRunButton(
    navController: NavController,
    appName: String
) {
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        onClick = { navController.navigate(appName.lowercase()) }
    ) {
        Text(
            text = appName,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}