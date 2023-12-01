package com.aradevs.pokeapp.domain.pokemon.detail

data class PokemonType(
    val slot: Int,
    val type: PokemonTypeDetail,
)

data class PokemonTypeDetail(
    val name: PokemonTypeName,
)