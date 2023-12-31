package com.aradevs.pokeapp.ui.detail.commons

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.palette.graphics.Palette
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonStat
import com.aradevs.pokeapp.domain.pokemon.detail.mockPokemonDetail
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.pokeapp.utils.MAX_POKEMON_EV
import com.aradevs.pokeapp.utils.toStringResource
import com.aradevs.pokeapp.utils.toTripeDigits

/**
 * Pokemon detail stat item composable
 * @param modifier [Modifier] to be applied to the container
 * @param palette [Palette] object to be used
 * @param pokemonStat [PokemonStat] object to be displayed
 */
@Composable
fun PokemonDetailStatItem(
    modifier: Modifier = Modifier,
    palette: Palette? = null,
    pokemonStat: PokemonStat
) {
    val percent = remember(MAX_POKEMON_EV) { Animatable(0F) }

    LaunchedEffect(pokemonStat.baseStat, MAX_POKEMON_EV) {
        percent.animateTo(
            targetValue = pokemonStat.baseStat.toFloat() / MAX_POKEMON_EV,
            animationSpec = tween(
                durationMillis = (1000 * (1f - percent.value)).toInt(),
                easing = FastOutLinearInEasing
            )
        )
    }

    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier.weight(0.4F),
            text = stringResource(id = pokemonStat.stat.name.toStringResource()),
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            fontFamily = AppFont.Montserrat,
            color = MaterialTheme.colorScheme.inverseOnSurface,
        )
        Spacer(modifier = Modifier.width(10.dp))
        LinearProgressIndicator(
            modifier = Modifier
                .weight(0.5F)
                .height(14.dp),
            progress = percent.value,
            strokeCap = StrokeCap.Round,
            color = palette?.vibrantSwatch?.let { Color(it.rgb) }
                ?: MaterialTheme.colorScheme.onPrimary,
            trackColor = palette?.vibrantSwatch?.let { Color(it.rgb).copy(alpha = 0.2F) }
                ?: MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.2F),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            modifier = Modifier.weight(0.1F),
            text = pokemonStat.baseStat.toTripeDigits(),
            textAlign = TextAlign.End,
            fontSize = 14.sp,
            fontWeight = FontWeight.W700,
            fontFamily = AppFont.Montserrat,
            color = MaterialTheme.colorScheme.onSecondary,
        )
    }
}

@Composable
@Preview
fun PokemonDetailStatItemPreview() {
    PokeappTheme {
        PokemonDetailStatItem(pokemonStat = mockPokemonDetail.stats.first())
    }
}