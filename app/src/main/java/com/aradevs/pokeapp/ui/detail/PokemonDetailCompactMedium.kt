package com.aradevs.pokeapp.ui.detail

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.detail.mockPokemonDetail
import com.aradevs.pokeapp.domain.pokemon.list.mockPokemon
import com.aradevs.pokeapp.ui.commons.PokemonDetailAppBar
import com.aradevs.pokeapp.ui.detail.commons.PokemonDetailDescription
import com.aradevs.pokeapp.ui.detail.commons.PokemonDetailHeader
import com.aradevs.pokeapp.ui.detail.commons.PokemonDetailInfo
import com.aradevs.pokeapp.ui.detail.commons.PokemonDetailStatItem
import com.aradevs.pokeapp.ui.detail.commons.PokemonDetailStatusHandler
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.pokeapp.utils.FoldableLandscapePreview
import com.aradevs.pokeapp.utils.FoldablePortraitPreview
import com.aradevs.pokeapp.utils.PhoneLandscapePreview
import com.aradevs.pokeapp.utils.TabletLandscapePreview
import com.aradevs.pokeapp.utils.TabletPortraitPreview
import com.aradevs.safe.safeInt
import com.aradevs.safe.safeString

@Composable
fun PokemonDetailCompactMedium(
    modifier: Modifier = Modifier,
    palette: Palette? = null,
    paletteSetter: (Palette) -> Unit = {},
    pokemonDetailActions: PokemonDetailActions
) {

    val currentPokemon by remember {
        pokemonDetailActions.getCurrentPokemon()
    }

    val currentPokemonDetail = pokemonDetailActions.getPokemonDetailStatus().collectAsState()

    Column {
        PokemonDetailAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(MaterialTheme.colorScheme.background),
            pokemon = currentPokemon,
            onBackPressed = {
                pokemonDetailActions.onBackButtonPressed()
            },
            onWikiPressed = {
                pokemonDetailActions.openWiki(currentPokemon?.name.safeString())
            }
        )
        PokemonDetailStatusHandler(
            modifier = Modifier.fillMaxSize(),
            status = currentPokemonDetail.value,
            onRetry = {
                pokemonDetailActions.getPokemonDetail()
            }
        )
        when (val status = currentPokemonDetail.value) {
            is Status.Success -> LazyColumn(modifier) {
                item {
                    Column {
                        Spacer(modifier = Modifier.height(8.dp))
                        PokemonDetailHeader(
                            pokemonDetail = status.data,
                            palette = palette,
                            paletteSetter = paletteSetter
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        PokemonDetailInfo(
                            modifier = Modifier
                                .height(58.dp)
                                .fillMaxWidth(), pokemonDetail = status.data
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        PokemonDetailDescription(pokemonDetailActions = pokemonDetailActions)
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
                items(status.data.stats) {
                    PokemonDetailStatItem(
                        modifier = Modifier.padding(vertical = 6.dp),
                        palette = palette,
                        pokemonStat = it
                    )
                }
            }

            else -> {
                //Do nothing
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
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun PokemonDetailCompactPreview() {
    PokeappTheme {
        Scaffold {
            PokemonDetailCompactMedium(
                modifier = Modifier.padding(
                    start = 15.dp,
                    end = 15.dp,
                    bottom = it.calculateBottomPadding(),
                ),
                pokemonDetailActions = MockPokemonDetailActions
            )
        }
    }
}