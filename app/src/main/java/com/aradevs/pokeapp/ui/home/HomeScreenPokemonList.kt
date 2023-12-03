package com.aradevs.pokeapp.ui.home

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.compose.itemKey
import com.aradevs.pokeapp.PokemonActions
import com.aradevs.pokeapp.ui.commons.PokemonCard
import com.aradevs.pokeapp.ui.detail.PokemonDetailActivity
import com.aradevs.pokeapp.ui.home.search.HomeScreenSearchContainer
import com.aradevs.pokeapp.utils.openNewPokemonDetailActivity

@Composable
fun HomeScreenPokemonList(modifier: Modifier = Modifier, pokemonActions: PokemonActions) {
    val pokemon = pokemonActions.getPokemonList()
    val context = LocalContext.current

    Column(modifier = modifier) {
        if (pokemonActions.getFilterValue().value.isEmpty()) {
            PokemonListErrorHandler(pokemonActions = pokemonActions)
        }
        if (pokemonActions.getFilterValue().value.isNotBlank()) {
            HomeScreenSearchContainer(
                modifier = Modifier.fillMaxSize(),
                pokemonActions = pokemonActions
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(165.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(pokemon.itemCount, key = pokemon.itemKey { it.id }) {
                pokemon[it]?.let { currentPokemon ->
                    PokemonCard(pokemon = currentPokemon, onTapped = {
                        context.openNewPokemonDetailActivity(currentPokemon.id, currentPokemon.name)
                    })
                }
            }
        }
    }
}