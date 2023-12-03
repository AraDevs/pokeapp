package com.aradevs.pokeapp.ui.detail.commons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aradevs.pokeapp.MockPokemonActions
import com.aradevs.pokeapp.PokemonActions
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.ui.commons.ErrorContainer
import com.aradevs.pokeapp.ui.commons.Loader
import com.aradevs.pokeapp.ui.detail.MockPokemonDetailActions
import com.aradevs.pokeapp.ui.detail.PokemonDetailActions
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.safe.safeString

@Composable
fun PokemonDetailDescription(
    modifier: Modifier = Modifier,
    pokemonDetailActions: PokemonDetailActions
) {
    val currentDescriptions = pokemonDetailActions.getPokemonSpeciesStatus().collectAsState()
    Column(modifier) {
        when (val status = currentDescriptions.value) {
            is Status.Success -> {
                Text(
                    text = status.data.flavorTextEntries.first().flavorText.safeString(),
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 12.sp,
                    fontFamily = AppFont.Montserrat,
                    fontWeight = FontWeight.W500
                )
            }

            is Status.Loading -> {
                Loader(modifier = Modifier.height(200.dp))
            }

            is Status.Error -> {
                ErrorContainer(modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(), onRetry = {
                    pokemonDetailActions.getPokemonSpecies()
                }, showImage = false
                )
            }

            else -> {
                //do nothing
            }
        }
    }
}

@Composable
@Preview
fun PokemonDetailDescriptionPreview() {
    PokeappTheme {
        PokemonDetailDescription(pokemonDetailActions = MockPokemonDetailActions)
    }
}