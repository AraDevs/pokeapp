package com.aradevs.pokeapp.ui.detail

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.palette.graphics.Palette
import com.aradevs.pokeapp.MockPokemonActions
import com.aradevs.pokeapp.PokemonActions
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.domain.pokemon.detail.mockPokemonDetail
import com.aradevs.pokeapp.domain.pokemon.list.mockPokemon
import com.aradevs.pokeapp.ui.commons.PokemonDetailAppBar
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonDetailCompact(modifier: Modifier = Modifier, pokemonActions: PokemonActions) {
    val palette: MutableState<Palette?> = remember {
        mutableStateOf(null)
    }

    LazyColumn(modifier) {
        stickyHeader {
            PokemonDetailAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(MaterialTheme.colorScheme.background),
                pokemon = mockPokemon
            )
        }
        item {
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                PokemonDetailHeader(
                    pokemonDetail = mockPokemonDetail,
                    palette = palette.value,
                    paletteSetter = {
                        palette.value = it
                    })
                Spacer(modifier = Modifier.height(10.dp))
                PokemonDetailInfo(
                    modifier = Modifier
                        .height(58.dp)
                        .fillMaxWidth(), pokemonDetail = mockPokemonDetail
                )
                Spacer(modifier = Modifier.height(10.dp))
                PokemonDetailDescription(pokemonActions = pokemonActions)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(id = R.string.stats),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    fontFamily = AppFont.Montserrat,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        items(mockPokemonDetail.stats) {
            PokemonDetailStatItem(
                modifier = Modifier.padding(vertical = 6.dp),
                palette = palette.value,
                pokemonStat = it
            )
        }
    }
}

@Composable
@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun PokemonDetailCompactPreview() {
    PokeappTheme {
        Scaffold {
            PokemonDetailCompact(
                modifier = Modifier.padding(
                    start = 15.dp,
                    end = 15.dp,
                    bottom = it.calculateBottomPadding(),
                ),
                pokemonActions = MockPokemonActions
            )
        }
    }
}