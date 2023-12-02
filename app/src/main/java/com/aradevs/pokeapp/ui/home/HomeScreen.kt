package com.aradevs.pokeapp.ui.home

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass) {
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompact(modifier = modifier)
        WindowWidthSizeClass.Medium -> HomeScreenMediumExpanded(modifier = modifier)
        WindowWidthSizeClass.Expanded -> HomeScreenMediumExpanded(modifier = modifier)
    }
}

