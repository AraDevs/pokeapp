package com.aradevs.pokeapp.ui.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.domain.pokemon.list.mockPokemon
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.pokeapp.utils.toTripeDigits
import com.aradevs.safe.safeInt
import com.aradevs.safe.safeString

/**
 * Pokemon card composable
 * @param modifier [Modifier] to be applied to the container
 * @param pokemon [Pokemon] object to be displayed
 * @param onBackPressed [() -> Unit] function to be executed when the back button is pressed
 * @param onWikiPressed [() -> Unit] function to be executed when the wiki button is pressed
 */
@Composable
fun PokemonDetailAppBar(
    modifier: Modifier = Modifier,
    pokemon: Pokemon? = null,
    onWikiPressed: () -> Unit = {},
    onBackPressed: () -> Unit = {}
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = onBackPressed) {
            Icon(
                modifier = Modifier.padding(0.dp),
                painter = painterResource(id = R.drawable.ic_left_arrow),
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }
        Text(
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 8.dp),
            text = pokemon?.name.safeString(),
            fontFamily = AppFont.Montserrat,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W700,
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clickable(onClick = onWikiPressed),
            text = "#${pokemon?.id.safeInt().toTripeDigits()}",
            fontFamily = AppFont.Montserrat,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = MaterialTheme.colorScheme.onSurface
            )
        )
    }
}

@Composable
@Preview
fun PokemonDetailAppBarPreview() {
    PokeappTheme {
        PokemonDetailAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(MaterialTheme.colorScheme.background),
            pokemon = mockPokemon
        )
    }
}