package com.aradevs.pokeapp.domain.pokemon.detail

data class PokemonStat(
    val baseStat: Int,
    val effort: Int,
    val stat: PokemonStatDetail,
)

data class PokemonStatDetail(
    val name: PokemonStatName,
)

fun mockPokemonStatDetail(name: PokemonStatName): PokemonStatDetail = PokemonStatDetail(
    name = name,
)

fun mockPokemonStat(baseStat: Int, name: PokemonStatName) = PokemonStat(
    baseStat = baseStat,
    effort = 100,
    stat = mockPokemonStatDetail(name),
)