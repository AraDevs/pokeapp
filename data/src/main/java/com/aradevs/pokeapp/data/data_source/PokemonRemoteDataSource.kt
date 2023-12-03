package com.aradevs.pokeapp.data.data_source

import com.aradevs.pokeapp.domain.pokemon.list.PokemonList
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.species.PokemonSpecies
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {
    suspend fun getPokemon(offset: Int = 0, limit: Int = 10): Status<PokemonList>

    fun getPokemonDetail(identifier: String): Flow<Status<PokemonDetail>>

    fun getPokemonSpecies(id: Int): Flow<Status<PokemonSpecies>>
}