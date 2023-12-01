package com.aradevs.pokeapp.data.data_source

import com.aradevs.pokeapp.domain.pokemon.PokemonList
import com.aradevs.pokeapp.domain.Status

interface PokemonRemoteDataSource {
    suspend fun getPokemon(offset: Int = 0, limit: Int = 10): Status<PokemonList>
}