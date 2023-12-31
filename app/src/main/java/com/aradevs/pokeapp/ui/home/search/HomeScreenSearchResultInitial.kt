package com.aradevs.pokeapp.ui.home.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
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
import com.aradevs.pokeapp.ui.theme.borderGray

/**
 * Home screen search result initial composable
 * @param modifier [Modifier] the composable modifier
 */
@Composable
fun HomeScreenSearchResultInitial(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.pokedex),
            contentDescription = "Pokedex"
        )
        Text(
            text = stringResource(id = R.string.search_a_pokemon),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = AppFont.Montserrat,
                fontWeight = FontWeight(600),
                color = borderGray,
            )
        )
    }
}

@Composable
@Preview
fun HomeScreenSearchResultInitialPreview() {
    PokeappTheme {
        HomeScreenSearchResultInitial()
    }
}