package com.aradevs.pokeapp.network

data class PokemonListSerializer(
    val next: String?,
    val previous: String?,
    val results: List<PokemonSerializer>?
)
data class PokemonSerializer(
    val name: String?,
    val url: String?
)

