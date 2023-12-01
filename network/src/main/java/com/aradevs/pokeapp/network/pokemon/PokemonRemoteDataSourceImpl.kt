package com.aradevs.pokeapp.network.pokemon

import android.util.Log
import com.aradevs.pokeapp.data.data_source.PokemonRemoteDataSource
import com.aradevs.pokeapp.domain.pokemon.list.PokemonList
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.species.PokemonSpecies
import com.aradevs.pokeapp.network.toDomain
import com.aradevs.safe.safeString
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

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

    override fun getPokemonDetail(id: Int): Flow<Status<PokemonDetail>> {
        return flow {
            emit(Status.Loading())
            val response = api.getPokemonDetail(id = id)
            when (response.code()) {

                200 -> response.body()?.let {
                    emit(Status.Success(it.toDomain()))
                } ?: emit(Status.Error(Exception("No data")))

                else -> {
                    emit(Status.Error(Exception(response.message())))
                }
            }
        }.catch {
            Log.e("Pokemon detail error", it.message.safeString())
            emit(Status.Error(Exception(it.message)))
        }
    }

    override fun getPokemonSpecies(id: Int): Flow<Status<PokemonSpecies>> {
        return flow {
            emit(Status.Loading())
            val response = api.getPokemonSpecies(id = id)
            when (response.code()) {

                200 -> response.body()?.let {
                    emit(Status.Success(it.toDomain()))
                } ?: emit(Status.Error(Exception("No data")))

                else -> {
                    emit(Status.Error(Exception(response.message())))
                }
            }
        }.catch {
            Log.e("Pokemon species error", it.message.safeString())
            emit(Status.Error(Exception(it.message)))
        }
    }
}