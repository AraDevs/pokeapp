package com.aradevs.pokeapp.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import com.aradevs.pokeapp.MockPokemonActions
import com.aradevs.pokeapp.PokemonActions
import com.aradevs.pokeapp.ui.home.commons.ErrorContainer
import com.aradevs.pokeapp.ui.home.commons.Loader
import com.aradevs.pokeapp.ui.home.commons.PokemonAppBar
import com.aradevs.pokeapp.ui.home.commons.PokemonListErrorHandler
import com.aradevs.pokeapp.ui.home.commons.PokemonSearchBar
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.pokeapp.ui.theme.borderGray

@Composable
fun HomeScreenCompact(modifier: Modifier = Modifier, pokemonActions: PokemonActions) {
    val pokemonPager = pokemonActions.getPokemonList()
    val annotatedString = buildAnnotatedString {
        append("¡Hola,")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(" bienvenido")
        }
        append("!")
    }
    Column(modifier = modifier) {
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
        Spacer(modifier = Modifier.height(12.dp))
        PokemonSearchBar(
            hint = "Buscar",
            modifier = Modifier
                .border(1.dp, borderGray, RoundedCornerShape(30.dp))
                .fillMaxWidth()
                .height(36.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        HomeScreenPokemonList(pokemonActions = pokemonActions)
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun HomeScreenPreview() {
    PokeappTheme {
        HomeScreenCompact(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(15.dp),
            pokemonActions = MockPokemonActions
        )
    }
}