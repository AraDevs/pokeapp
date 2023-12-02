package com.aradevs.pokeapp.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
    primary = deepBlueDarkTheme,
    onPrimary = mainTextDarkTheme,
    inversePrimary = blueAccentDarkTheme,
    secondary = yellowAccentDarkTheme,
    onSecondary = blackDarkTheme,
    background = mainSurfaceDarkTheme,
    onBackground = mainTextDarkTheme,
    surface = cardSurfaceDarkTheme,
    onSurface = secondaryTextDarkTheme,
    inverseOnSurface = darkGrayDarkTheme,
    error = Color.Red,
    onError = Color.White,
)


private val lightColorScheme = lightColorScheme(
    primary = deepBlue,
    onPrimary = mainText,
    inversePrimary = blueAccent,
    secondary = yellowAccent,
    onSecondary = black,
    background = mainSurface,
    onBackground = mainText,
    surface = cardSurface,
    onSurface = secondaryText,
    inverseOnSurface = darkGray,
    error = Color.Red,


    onError = Color.White,
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun PokeappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}