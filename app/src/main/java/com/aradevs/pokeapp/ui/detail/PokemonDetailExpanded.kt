package com.aradevs.pokeapp.ui.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.palette.graphics.Palette
import com.aradevs.pokeapp.MockPokemonActions
import com.aradevs.pokeapp.PokemonActions
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.domain.pokemon.detail.mockPokemonDetail
import com.aradevs.pokeapp.domain.pokemon.list.mockPokemon
import com.aradevs.pokeapp.ui.commons.PokemonDetailAppBar
import com.aradevs.pokeapp.ui.detail.commons.PokemonDetailDescription
import com.aradevs.pokeapp.ui.detail.commons.PokemonDetailHeader
import com.aradevs.pokeapp.ui.detail.commons.PokemonDetailInfo
import com.aradevs.pokeapp.ui.detail.commons.PokemonDetailStatItem
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.pokeapp.utils.FoldableLandscapePreview
import com.aradevs.pokeapp.utils.FoldablePortraitPreview
import com.aradevs.pokeapp.utils.PhoneLandscapePreview
import com.aradevs.pokeapp.utils.TabletLandscapePreview
import com.aradevs.pokeapp.utils.TabletPortraitPreview

@Composable
fun PokemonDetailExpanded(
    modifier: Modifier = Modifier,
    palette: Palette? = null,
    paletteSetter: (Palette) -> Unit = {},
    pokemonDetailActions: PokemonDetailActions
) {

    val currentPokemon by remember {
        pokemonDetailActions.getCurrentPokemon()
    }

    Column {
        PokemonDetailAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(MaterialTheme.colorScheme.background),
            pokemon = currentPokemon
        )
        Row(modifier) {
            Column(
                Modifier
                    .weight(0.5F)
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PokemonDetailHeader(
                    pokemonDetail = mockPokemonDetail,
                    palette = palette,
                    paletteSetter = paletteSetter
                )
                Spacer(modifier = Modifier.height(10.dp))
                PokemonDetailInfo(
                    modifier = Modifier
                        .height(58.dp)
                        .fillMaxWidth(), pokemonDetail = mockPokemonDetail
                )
                Spacer(modifier = Modifier.height(10.dp))
                PokemonDetailDescription(pokemonDetailActions = pokemonDetailActions)
            }
            Spacer(modifier = Modifier.width(30.dp))
            LazyColumn(
                Modifier
                    .weight(0.5F)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(0.8F),
                        horizontalAlignment = Alignment.Start
                    ) {
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
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                            .fillMaxWidth(0.8F),
                        palette = palette,
                        pokemonStat = it
                    )
                }
            }
        }
    }
}

@Composable
@TabletLandscapePreview
@TabletPortraitPreview
@FoldablePortraitPreview
@FoldableLandscapePreview
@PhoneLandscapePreview
fun PokemonDetailMediumExpandedPreview() {
    PokeappTheme {
        PokemonDetailExpanded(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(15.dp),
            pokemonDetailActions = MockPokemonDetailActions,
        )
    }
}