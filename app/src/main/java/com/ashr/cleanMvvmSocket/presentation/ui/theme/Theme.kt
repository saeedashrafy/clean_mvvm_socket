package com.ashr.cleanMvvmSocket.presentation.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = Black,
    primaryVariant = Blue,
    onPrimary = White,
    secondary = Blue,
    secondaryVariant = RedDark,
    onSecondary = White,

    background = BackgroundDark,
    onBackground = White,

    surface = CardDark,
    onSurface = CardDark
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = Blue,
    onPrimary = Black,
    secondary = Blue,
    secondaryVariant = Blue,
    onSecondary = Black,

    background = BackgroundLight,
    onBackground = Black,

    surface = White,
    onSurface = White
)


@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}