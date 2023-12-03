package com.aradevs.pokeapp.ui.home

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aradevs.pokeapp.PokemonActions

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass,
    pokemonActions: PokemonActions,
) {
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompact(
            modifier = modifier,
            pokemonActions = pokemonActions
        )
        WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded -> HomeScreenMediumExpanded(
            modifier = modifier,
            pokemonActions = pokemonActions
        )
    }
}

