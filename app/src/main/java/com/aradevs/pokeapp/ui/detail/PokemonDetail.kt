package com.aradevs.pokeapp.ui.detail

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.palette.graphics.Palette
import com.aradevs.pokeapp.PokemonActions

/**
 * Pokemon detail composable
 * @param modifier [Modifier] to be applied to the container
 * @param windowSizeClass [WindowSizeClass] object to be used
 * @param pokemonDetailActions [PokemonActions] object to be used
 * @param pokemonDetailActions [PokemonDetailActions] object to be used
 */
@Composable
fun PokemonDetail(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass,
    pokemonDetailActions: PokemonDetailActions,
) {
    val palette: MutableState<Palette?> = remember {
        mutableStateOf(null)
    }

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> PokemonDetailCompactMedium(
            modifier = modifier,
            palette = palette.value,
            paletteSetter = { palette.value = it },
            pokemonDetailActions = pokemonDetailActions
        )

        WindowWidthSizeClass.Expanded -> PokemonDetailExpanded(
            modifier = modifier,
            palette = palette.value,
            paletteSetter = { palette.value = it },
            pokemonDetailActions = pokemonDetailActions
        )
    }
}