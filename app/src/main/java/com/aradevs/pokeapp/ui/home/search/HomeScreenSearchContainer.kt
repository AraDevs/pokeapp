package com.aradevs.pokeapp.ui.home.search

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aradevs.pokeapp.MockPokemonActions
import com.aradevs.pokeapp.PokemonActions
import com.aradevs.pokeapp.domain.PokemonNotFoundException
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.ui.commons.ErrorContainer
import com.aradevs.pokeapp.ui.commons.Loader

/**
 * Home screen search container composable
 * @param modifier [Modifier] to be applied to the container
 * @param pokemonActions [PokemonActions] object to be useds
 */
@Composable
fun HomeScreenSearchContainer(modifier: Modifier = Modifier, pokemonActions: PokemonActions) {
    val currentPokemonDetail = pokemonActions.getCurrentPokemonDetail().collectAsState()
    Box(modifier = modifier) {
        when (val status = currentPokemonDetail.value) {
            is Status.Loading -> Loader(modifier = Modifier.align(Alignment.Center))

            is Status.Success -> HomeScreenSearchResultSuccess(pokemonDetail = status.data)

            is Status.Error -> {
                if (status.exception is PokemonNotFoundException) {
                    HomeScreenSearchResultNotFound(modifier = Modifier.align(Alignment.Center))
                } else {
                    ErrorContainer(modifier = Modifier.align(Alignment.Center), onRetry = {
                        pokemonActions.getPokemonDetail(pokemonActions.getFilterValue().value)
                    })
                }
            }

            is Status.Initial -> HomeScreenSearchResultInitial(modifier = Modifier.align(Alignment.Center))

            else -> {
                //do nothing
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenSearchContainerPreview() {
    HomeScreenSearchContainer(pokemonActions = MockPokemonActions)
}