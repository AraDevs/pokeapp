package com.aradevs.pokeapp.data.repository

import com.aradevs.pokeapp.data.data_source.PokemonRemoteDataSource
import com.aradevs.pokeapp.domain.pokemon.list.PokemonList
import com.aradevs.pokeapp.domain.Status

class PokemonRepository(private val pokemonRemoteDataSource: PokemonRemoteDataSource) {
    suspend fun getPokemon(offset: Int = 0, limit: Int = 10): Status<PokemonList> =
        pokemonRemoteDataSource.getPokemon(offset, limit)

    fun getPokemonDetail(id: Int) = pokemonRemoteDataSource.getPokemonDetail(id)

    fun getPokemonSpecies(id: Int) = pokemonRemoteDataSource.getPokemonSpecies(id)
}