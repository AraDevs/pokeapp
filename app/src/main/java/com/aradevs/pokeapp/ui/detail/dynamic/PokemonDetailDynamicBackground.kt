package com.aradevs.pokeapp.ui.detail.dynamic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.aradevs.pokeapp.ui.theme.PokeappTheme

/**
 * Pokemon detail dynamic background composable
 * @param palette [Palette] object to be used to generate the background
 */
@Composable
fun PokemonDetailDynamicBackground(palette: Palette?) {
    Box(
        modifier = Modifier
            .padding(top = 100.dp)
            .height(157.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(size = 15.dp),
                spotColor = Color.Black,
                ambientColor = Color.Black
            )
            .background(palette?.vibrantSwatch?.let { Color(it.rgb) }
                ?: MaterialTheme.colorScheme.surface),
    )
}

@Composable
@Preview
fun PokemonDetailDynamicBackgroundPreview() {
    PokeappTheme {
        PokemonDetailDynamicBackground(
            palette = null
        )
    }
}