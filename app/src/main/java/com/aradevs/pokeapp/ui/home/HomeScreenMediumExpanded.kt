package com.aradevs.pokeapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aradevs.pokeapp.MockPokemonActions
import com.aradevs.pokeapp.PokemonActions
import com.aradevs.pokeapp.ui.commons.PokemonAppBar
import com.aradevs.pokeapp.ui.commons.PokemonSearchBar
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.pokeapp.ui.theme.borderGray
import com.aradevs.pokeapp.utils.TabletLandscapePreview

@Composable
fun HomeScreenMediumExpanded(
    modifier: Modifier = Modifier,
    pokemonActions: PokemonActions,
) {
    val annotatedString = buildAnnotatedString {
        append("¡Hola,")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(" bienvenido")
        }
        append("!")
    }
    Row(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.35f),
            verticalArrangement = Arrangement.Center
        ) {
            PokemonAppBar()
            Spacer(modifier = Modifier.height(31.dp))
            Text(
                text = annotatedString,
                fontFamily = AppFont.Montserrat,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            PokemonSearchBar(
                hint = "Buscar",
                currentValue = pokemonActions.getFilterValue().value,
                onValueChanged = { newValue -> pokemonActions.updateFilterValue(newValue) },
                onSearch = {
                    pokemonActions.getPokemonDetail(pokemonActions.getFilterValue().value)
                },
                modifier = Modifier
                    .border(1.dp, borderGray, RoundedCornerShape(30.dp))
                    .fillMaxWidth()
                    .height(36.dp)
            )
        }
        Spacer(modifier = Modifier.width(30.dp))
        HomeScreenPokemonList(modifier = Modifier.weight(0.65f), pokemonActions = pokemonActions)
    }
}

@Composable
@TabletLandscapePreview
fun HomeScreenMediumExpandedPreview() {
    PokeappTheme {
        HomeScreenMediumExpanded(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(15.dp),
            pokemonActions = MockPokemonActions,
        )
    }
}