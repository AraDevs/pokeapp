package com.aradevs.pokeapp.domain.pokemon.detail

import android.util.Log
import com.aradevs.pokeapp.domain.obtainPokemonImage
import com.aradevs.pokeapp.domain.obtainPokemonUrl
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon

data class PokemonDetail(
    val id: String,
    val name: String,
    val height: Int,
    val weight: Int,
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
    height = 7,
    weight = 50,
    stats = listOf(
        mockPokemonStat(45, PokemonStatName.HP),
        mockPokemonStat(49, PokemonStatName.ATTACK),
        mockPokemonStat(30, PokemonStatName.DEFENSE),
        mockPokemonStat(21, PokemonStatName.SPECIAL_ATTACK),
        mockPokemonStat(33, PokemonStatName.SPECIAL_DEFENSE),
        mockPokemonStat(45, PokemonStatName.SPEED),
    ),
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
