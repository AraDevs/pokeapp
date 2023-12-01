package com.aradevs.pokeapp.domain.pokemon.detail.species

data class PokemonSpecies(
    val id: String,
    val flavorTextEntries: List<PokemonSpeciesFlavorTextEntry>,
)