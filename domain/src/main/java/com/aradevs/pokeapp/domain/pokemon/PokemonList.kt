package com.aradevs.pokeapp.domain.pokemon

data class PokemonList(
    val next: String,
    val previous: String,
    val results: List<Pokemon>
)