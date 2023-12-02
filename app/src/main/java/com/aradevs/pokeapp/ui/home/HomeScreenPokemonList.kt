package com.aradevs.pokeapp.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.itemKey
import com.aradevs.pokeapp.PokemonActions
import com.aradevs.pokeapp.ui.home.commons.PokemonCard

@Composable
fun HomeScreenPokemonList(modifier: Modifier = Modifier, pokemonActions: PokemonActions) {
    val pokemon = pokemonActions.getPokemonList()
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(165.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(pokemon.itemCount, key = pokemon.itemKey { it.id }) {
            pokemon[it]?.let { currentPokemon ->
                PokemonCard(pokemon = currentPokemon)
            }
        }
    }
}