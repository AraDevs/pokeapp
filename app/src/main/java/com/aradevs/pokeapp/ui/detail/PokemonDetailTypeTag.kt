package com.aradevs.pokeapp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aradevs.pokeapp.ui.theme.PokeappTheme

@Composable
fun PokemonDetailTypeTag(text: String) {
    Box(
        modifier = Modifier
            .height(24.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(size = 21.dp),
                spotColor = Color.Black,
                ambientColor = Color.Black
            )
            .border(1.dp, MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(size = 21.dp))
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .align(Alignment.Center),
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Composable
@Preview
fun PokemonDetailDynamicTagPreview() {
    PokeappTheme {
        PokemonDetailTypeTag(
            text = "test"
        )
    }
}