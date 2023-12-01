package com.aradevs.pokeapp.domain.pokemon.list

data class PokemonList(
    val next: String,
    val previous: String,
    val results: List<Pokemon>
)