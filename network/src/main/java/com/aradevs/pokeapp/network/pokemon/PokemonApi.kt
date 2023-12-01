package com.aradevs.pokeapp.network.pokemon

import com.aradevs.pokeapp.network.PokemonListSerializer
import com.aradevs.pokeapp.network.pokemon.PokemonApi.Constants.POKEMON
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET(POKEMON)
    suspend fun getPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<PokemonListSerializer>

    companion object Constants {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
        const val POKEMON = "pokemon/"
    }
}