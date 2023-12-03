package com.aradevs.pokeapp.ui.home.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.toPokemon
import com.aradevs.pokeapp.ui.home.commons.PokemonCard
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.borderGray

@Composable
fun HomeScreenSearchResultSuccess(modifier: Modifier = Modifier, pokemonDetail: PokemonDetail) {
    Column(modifier = modifier, horizontalAlignment = Alignment.Start) {
        Text(
            text = "Resultado de búsqueda",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = AppFont.Montserrat,
                fontWeight = FontWeight(600),
                color = borderGray,
            )
        )
        Spacer(modifier = Modifier.height(23.dp))
        PokemonCard(
            modifier = Modifier
                .size(165.dp),
            pokemon = pokemonDetail.toPokemon()
        )
    }
}