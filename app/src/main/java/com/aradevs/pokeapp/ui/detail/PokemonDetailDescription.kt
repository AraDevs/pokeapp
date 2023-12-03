package com.aradevs.pokeapp.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.aradevs.pokeapp.MockPokemonActions
import com.aradevs.pokeapp.PokemonActions
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme

@Composable
fun PokemonDetailDescription(modifier: Modifier = Modifier, pokemonActions: PokemonActions) {
    Column(modifier) {
        Text(
            text = "La figura de Charizard es la de un dragón erguido sobre sus dos patas traseras, que sostienen su peso. Posee unas poderosas alas y un abrasador aliento de fuego.",
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 12.sp,
            fontFamily = AppFont.Montserrat,
            fontWeight = FontWeight.W500
        )
    }
}

@Composable
@Preview
fun PokemonDetailDescriptionPreview() {
    PokeappTheme {
        PokemonDetailDescription(pokemonActions = MockPokemonActions)
    }
}