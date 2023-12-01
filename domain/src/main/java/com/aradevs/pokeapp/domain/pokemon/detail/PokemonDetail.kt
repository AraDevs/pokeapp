package com.aradevs.pokeapp.domain.pokemon.detail

data class PokemonDetail(
    val id: String,
    val name: String,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>
)
