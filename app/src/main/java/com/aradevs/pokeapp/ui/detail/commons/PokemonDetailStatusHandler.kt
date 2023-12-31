package com.aradevs.pokeapp.ui.detail.commons

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.ui.commons.ErrorContainer
import com.aradevs.pokeapp.ui.commons.Loader

/**
 * Pokemon detail status handler composable
 * @param modifier [Modifier] to be applied to the container
 * @param status [Status] object to be displayed
 * @param onRetry [Function] to be called when retrying
 */
@Composable
fun PokemonDetailStatusHandler(
    modifier: Modifier = Modifier,
    status: Status<PokemonDetail>,
    onRetry: () -> Unit
) {
    when (status) {
        is Status.Error -> {
            ErrorContainer(modifier,onRetry = onRetry)
        }

        is Status.Loading -> {
            Box(modifier = modifier) {
                Loader()
            }
        }

        else -> {
            //no-op
        }
    }
}