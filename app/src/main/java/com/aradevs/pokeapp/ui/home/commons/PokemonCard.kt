package com.aradevs.pokeapp.ui.home.commons

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.domain.pokemon.list.mockPokemon
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.pokeapp.ui.theme.rounded10Shape
import com.aradevs.pokeapp.ui.theme.shadowColor
import com.aradevs.pokeapp.utils.toTripeDigits

@Composable
fun PokemonCard(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .shadow(
                    elevation = 28.dp,
                    shape = rounded10Shape,
                    spotColor = shadowColor,
                    ambientColor = shadowColor
                )
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 22.dp)
                    .align(Center),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "#${pokemon.id.toTripeDigits()}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W500,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                AsyncImage(
                    modifier = Modifier
                        .size(81.dp)
                        .padding(vertical = 4.dp)
                        .align(CenterHorizontally),
                    placeholder = painterResource(id = R.drawable.pokemon_logo),
                    error = painterResource(id = R.drawable.pokemon_missingno),
                    model = pokemon.image,
                    contentDescription = null
                )
                Text(
                    text = pokemon.name,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.W600,
                )
            }
        }
    }
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_NO)
fun PokemonCardPreview() {
    PokeappTheme {
        /*Scaffold(contentColor = MaterialTheme.colorScheme.background) {
            LazyVerticalGrid(
                modifier = Modifier.padding(it),
                columns = GridCells.Adaptive(165.dp),
                contentPadding = PaddingValues(15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(10) {
                    PokemonCard(pokemon = mockPokemon)
                }
            }
        }
    }*/
        PokemonCard(modifier = Modifier.size(165.dp), pokemon = mockPokemon)
    }
}