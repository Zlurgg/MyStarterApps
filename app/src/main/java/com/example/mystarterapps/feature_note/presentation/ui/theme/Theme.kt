package com.example.mystarterapps.feature_note.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val darkColorPalette = darkColorScheme(
    primary = Color.White,
    background = DarkGray,
    onBackground = Color.White,
    surface = LightBlue,
    onSurface = DarkGray
)

@Composable
fun NoteAppTheme(darkTheme: Boolean = false, content: @Composable() () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorPalette,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}