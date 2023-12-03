package com.aradevs.pokeapp.ui.home.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme

@Composable
fun HomeScreenSearchResultNotFound(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.pokemon_missingno),
            contentDescription = "Missingno",
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            stringResource(id = R.string.we_could_not_find_any_pokemon),
            fontFamily = AppFont.Montserrat,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.W700,
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
    }
}

@Composable
@Preview
fun HomeScreenSearchResultNotFoundPreview() {
    PokeappTheme {
        HomeScreenSearchResultNotFound()
    }
}