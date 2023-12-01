package com.aradevs.pokeapp.domain.pokemon.detail

data class PokemonStat(
    val baseStat: Int,
    val effort: Int,
    val stat: PokemonStatDetail,
)

data class PokemonStatDetail(
    val name: PokemonStatName,
)