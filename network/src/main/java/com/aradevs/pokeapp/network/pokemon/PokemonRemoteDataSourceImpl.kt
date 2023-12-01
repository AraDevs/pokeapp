package com.aradevs.pokeapp.network.pokemon

import com.aradevs.pokeapp.data.data_source.PokemonRemoteDataSource
import com.aradevs.pokeapp.domain.pokemon.list.PokemonList
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.network.toDomain

class PokemonRemoteDataSourceImpl(private val api: PokemonApi) : PokemonRemoteDataSource {
    override suspend fun getPokemon(offset: Int, limit: Int): Status<PokemonList> {
        val response = api.getPokemon(offset = offset, limit = limit)
        return when (response.code()) {

            200 -> response.body()?.let {
                Status.Success(it.toDomain())
            } ?: Status.Error(Exception("No data"))

            else -> {
                Status.Error(Exception(response.message()))
            }
        }
    }
}