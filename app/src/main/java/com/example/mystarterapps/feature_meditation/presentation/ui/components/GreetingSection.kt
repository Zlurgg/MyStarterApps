package com.example.mystarterapps.feature_meditation.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mystarterapps.R
import com.example.mystarterapps.feature_meditation.presentation.ui.theme.TextWhite

@Composable
fun GreetingSection(
    name: String = "Joe"
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Good morning, $name",
                    style = MaterialTheme.typography.headlineMedium,
                    color = TextWhite
                )
                Text(
                    text = "We wish you have a good day!",
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextWhite
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = TextWhite,
                modifier = Modifier.size(24.dp)
            )
        }
    }