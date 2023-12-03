package com.aradevs.pokeapp.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.domain.obtainPokemonImage
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.mockPokemonDetail
import com.aradevs.pokeapp.ui.detail.dynamic.PokemonDetailDynamicBackground
import com.aradevs.pokeapp.ui.theme.PokeappTheme

@Composable
fun PokemonDetailHeader(modifier: Modifier = Modifier, pokemonDetail: PokemonDetail) {

    val palette: MutableState<Palette?> = remember {
        mutableStateOf(null)
    }

    val imagePainter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .placeholder(R.drawable.pokemon_logo)
            .error(R.drawable.pokemon_missingno)
            .data(data = obtainPokemonImage(pokemonDetail.id.toInt()))
            .allowHardware(false)
            .build(),
        onState = { state ->
            if (state is AsyncImagePainter.State.Success) {
                val bitmap = state.result.drawable.toBitmap()
                palette.value = Palette.from(bitmap).generate()
            }
        }
    )

    Box(modifier = modifier) {
        PokemonDetailDynamicBackground(palette = palette.value)
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .height(175.dp)
                    .width(175.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow {
                items(pokemonDetail.types.size) { index ->
                    PokemonDetailTypeTag(
                        text = pokemonDetail.types[index].type.name.name
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
    }

}

@Preview
@Composable
fun PokemonDetailHeaderPreview() {
    PokeappTheme {
        PokemonDetailHeader(pokemonDetail = mockPokemonDetail)
    }
}