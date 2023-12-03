package com.aradevs.pokeapp.domain.pokemon.detail

import kotlin.random.Random

data class PokemonStat(
    val baseStat: Int,
    val effort: Int,
    val stat: PokemonStatDetail,
)

data class PokemonStatDetail(
    val name: PokemonStatName,
)

/**
 * Mocks a [PokemonStatDetail]
 */
fun mockPokemonStatDetail(name: PokemonStatName): PokemonStatDetail = PokemonStatDetail(
    name = name,
)

/**
 * Mocks a [PokemonStat]
 */
fun mockPokemonStat(baseStat: Int, name: PokemonStatName) = PokemonStat(
    baseStat = baseStat,
    effort = Random.nextInt(from =1, until = 255),
    stat = mockPokemonStatDetail(name),
)