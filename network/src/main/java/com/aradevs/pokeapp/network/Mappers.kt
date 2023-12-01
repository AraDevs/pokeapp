package com.aradevs.pokeapp.network

import com.aradevs.pokeapp.domain.pokemon.Pokemon
import com.aradevs.pokeapp.domain.pokemon.PokemonList
import com.aradevs.pokeapp.domain.capitalized
import com.aradevs.safe.safeString

fun PokemonSerializer.toDomain(): Pokemon {
    return Pokemon(
        name = name.safeString().capitalized(),
        url = url.safeString()
    )
}

fun PokemonListSerializer.toDomain(): PokemonList {
    return PokemonList(
        next = next.safeString(),
        previous = previous.safeString(),
        results = results?.map { it.toDomain() } ?: emptyList()
    )
}