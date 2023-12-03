package com.aradevs.pokeapp.domain.pokemon.detail

import android.util.Log
import com.aradevs.pokeapp.domain.obtainPokemonImage
import com.aradevs.pokeapp.domain.obtainPokemonUrl
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon

data class PokemonDetail(
    val id: String,
    val name: String,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>
)

fun PokemonDetail.toPokemon(): Pokemon {
    Log.e("PokemonDetail", "toPokemon: $this")
    return Pokemon(
        id = id.toInt(),
        name = name,
        image = obtainPokemonImage(id.toInt()),
        url = obtainPokemonUrl(id.toInt())
    )
}

val mockPokemonDetail = PokemonDetail(
    id = "1",
    name = "bulbasaur",
    stats = listOf(),
    types = listOf(
        PokemonType(
            slot = 1,
            type = PokemonTypeDetail(
                name = PokemonTypeName.GRASS,
            )
        ),
        PokemonType(
            slot = 2,
            type = PokemonTypeDetail(
                name = PokemonTypeName.POISON,
            )
        )
    )
)
