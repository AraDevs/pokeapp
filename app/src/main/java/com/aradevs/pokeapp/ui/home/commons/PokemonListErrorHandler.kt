package com.aradevs.pokeapp.ui.home.commons

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import com.aradevs.pokeapp.PokemonActions

@Composable
fun PokemonListErrorHandler(pokemonActions: PokemonActions) {
    val pokemonPager = pokemonActions.getPokemonList()
    if (pokemonPager.loadState.refresh is LoadState.Error ||
        pokemonPager.loadState.append is LoadState.Error ||
        pokemonPager.loadState.prepend is LoadState.Error
    ) {
        ErrorContainer(modifier = Modifier.fillMaxSize(), onRetry = { pokemonPager.retry() })
    }
    if (
        pokemonPager.loadState.refresh is LoadState.Loading ||
        pokemonPager.loadState.prepend is LoadState.Loading ||
        pokemonPager.loadState.append is LoadState.Loading
    ) {
        Loader(modifier = Modifier.fillMaxWidth())
    }
}