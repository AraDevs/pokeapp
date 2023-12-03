package com.aradevs.pokeapp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aradevs.pokeapp.MockPokemonActions
import com.aradevs.pokeapp.PokemonActions
import com.aradevs.pokeapp.domain.pokemon.detail.mockPokemonDetail
import com.aradevs.pokeapp.domain.pokemon.list.mockPokemon
import com.aradevs.pokeapp.ui.commons.PokemonDetailAppBar
import com.aradevs.pokeapp.ui.theme.PokeappTheme

@Composable
fun PokemonDetailCompact(modifier: Modifier = Modifier, pokemonActions: PokemonActions) {
    Column(modifier) {
        PokemonDetailAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(MaterialTheme.colorScheme.background),
            pokemon = mockPokemon
        )
        Column(
            Modifier
                .padding(horizontal = 15.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            PokemonDetailHeader(pokemonDetail = mockPokemonDetail)
            Spacer(modifier = Modifier.height(10.dp))
            PokemonDetailInfo(
                modifier = Modifier
                    .height(58.dp)
                    .fillMaxWidth(), pokemonDetail = mockPokemonDetail
            )
            Spacer(modifier = Modifier.height(10.dp))
            PokemonDetailDescription(pokemonActions = pokemonActions)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
@Preview
fun PokemonDetailCompactPreview() {
    PokeappTheme {
        Scaffold {
            PokemonDetailCompact(
                modifier = Modifier.padding(it),
                pokemonActions = MockPokemonActions
            )
        }
    }
}