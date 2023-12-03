package com.aradevs.pokeapp.network.pokemon

import android.util.Log
import com.aradevs.pokeapp.data.data_source.PokemonRemoteDataSource
import com.aradevs.pokeapp.domain.FIRST_GEN_POKEMON_COUNT
import com.aradevs.pokeapp.domain.PokemonNotFoundException
import com.aradevs.pokeapp.domain.pokemon.list.PokemonList
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.species.PokemonSpecies
import com.aradevs.pokeapp.network.toDomain
import com.aradevs.safe.safeString
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

const val NO_DATA = "No data"

class PokemonRemoteDataSourceImpl(private val api: PokemonApi) : PokemonRemoteDataSource {
    /**
     * Get pokemon list from api
     * @param offset Int start point for pagination
     * @param limit Int items per request
     * @return Status<PokemonList>
     */
    override suspend fun getPokemon(offset: Int, limit: Int): Status<PokemonList> {
        val response = api.getPokemon(offset = offset, limit = limit)
        return when (response.code()) {

            200 -> response.body()?.let {
                Status.Success(it.toDomain())
            } ?: Status.Error(Exception(NO_DATA))

            else -> {
                Status.Error(Exception(response.message()))
            }
        }
    }

    /**
     * Get pokemon detail from api
     * @param identifier String pokemon identifier
     * @return Status<PokemonDetail>
     */
    override fun getPokemonDetail(identifier: String): Flow<Status<PokemonDetail>> {
        return flow {
            emit(Status.Loading())
            val response = api.getPokemonDetail(identifier = identifier)
            when (response.code()) {
                200 -> response.body()?.let {
                    val pokemonDetail = it.toDomain()
                    if (pokemonDetail.id.toInt() <= FIRST_GEN_POKEMON_COUNT) {
                        emit(Status.Success(pokemonDetail))
                    } else {
                        emit(Status.Error(PokemonNotFoundException("Pokemon not found")))
                    }
                } ?: emit(Status.Error(Exception(NO_DATA)))

                404 -> {
                    emit(Status.Error(PokemonNotFoundException("Pokemon not found")))
                }

                else -> {
                    emit(Status.Error(Exception(response.message())))
                }
            }
        }.catch {
            Log.e("Pokemon detail error", it.message.safeString())
            emit(Status.Error(Exception(it.message)))
        }
    }

    /**
     * Get pokemon species from api
     * @param id Int pokemon id
     * @return Status<PokemonSpecies>
     */
    override fun getPokemonSpecies(id: Int): Flow<Status<PokemonSpecies>> {
        return flow {
            emit(Status.Loading())
            val response = api.getPokemonSpecies(id = id)
            when (response.code()) {

                200 -> response.body()?.let {
                    emit(Status.Success(it.toDomain()))
                } ?: emit(Status.Error(Exception(NO_DATA)))

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