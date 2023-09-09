package com.example.mystarterapps.feature_stock_market.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val darkColorPalette = darkColorScheme(
    primary = Color.Green,
    background = DarkBlue,
    inversePrimary = Color.DarkGray,
    onBackground = TextWhite
)

@Composable
fun StockMarketAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = darkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}