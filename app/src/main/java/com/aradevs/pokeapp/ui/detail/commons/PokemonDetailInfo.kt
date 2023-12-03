package com.aradevs.pokeapp.ui.detail.commons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.mockPokemonDetail
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.pokeapp.ui.theme.rounded10Shape
import com.aradevs.pokeapp.utils.decimeterToMeters
import com.aradevs.pokeapp.utils.hectogramsToKilograms

/**
 * Pokemon detail info composable
 * @param modifier [Modifier] to be applied to the container
 * @param pokemonDetail [PokemonDetail] object to be displayed
 */
@Composable
fun PokemonDetailInfo(modifier: Modifier = Modifier, pokemonDetail: PokemonDetail) {
    Card(
        modifier = modifier,
        shape = rounded10Shape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExperienceDetailInfoItem(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxHeight(),
                icon = R.drawable.ic_ruler,
                title = "${pokemonDetail.height.decimeterToMeters()}m",
                subtitle = R.string.height
            )
            Spacer(modifier = Modifier.width(10.dp))
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp),
                thickness = 1.dp,
            )
            ExperienceDetailInfoItem(
                modifier = Modifier
                    .weight(1F),
                icon = R.drawable.ic_scale,
                title = "${pokemonDetail.weight.hectogramsToKilograms()}kg",
                subtitle = R.string.weight
            )
        }
    }
}

@Composable
fun ExperienceDetailInfoItem(
    modifier: Modifier,
    @DrawableRes icon: Int,
    title: String,
    @StringRes subtitle: Int,
) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.inversePrimary
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(
                text = title,
                fontSize = 14.sp,
                fontFamily = AppFont.Montserrat,
                fontWeight = FontWeight.W700,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                text = stringResource(id = subtitle),
                fontSize = 10.sp,
                fontFamily = AppFont.Montserrat,
                fontWeight = FontWeight.W400,
                color = MaterialTheme.colorScheme.inversePrimary,
            )
        }
    }
}

@Composable
@Preview
fun ExperienceDetailInfoPreview() {
    PokeappTheme {
        PokemonDetailInfo(
            modifier = Modifier
                .height(58.dp)
                .fillMaxWidth(),
            pokemonDetail = mockPokemonDetail
        )
    }
}

@Composable
@Preview
fun ExperienceDetailInfoItemPreview() {
    PokeappTheme {
        ExperienceDetailInfoItem(
            modifier = Modifier
                .height(58.dp)
                .fillMaxWidth(),
            icon = R.drawable.ic_ruler,
            title = "1.2m",
            subtitle = R.string.height
        )
    }
}