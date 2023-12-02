package com.aradevs.pokeapp.ui.home.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.ui.theme.PokeappTheme

@Composable
fun PokemonAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(46.dp),
            painter = painterResource(id = R.drawable.pokemon_logo),
            contentDescription = "Pokeball",
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = stringResource(id = R.string.home_title),
            style = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.W700
            ),
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun PokemonAppBarPreview() {
    PokeappTheme {
        PokemonAppBar()
    }
}