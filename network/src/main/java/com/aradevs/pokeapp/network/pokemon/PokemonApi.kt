package com.aradevs.pokeapp.network.pokemon

import com.aradevs.pokeapp.network.PokemonDetailSerializer
import com.aradevs.pokeapp.network.PokemonListSerializer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET(POKEMON)
    suspend fun getPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<PokemonListSerializer>

    @GET(POKEMON_DETAIL)
    fun getPokemonDetail(
        @Path("id") id: Int
    ): Response<PokemonDetailSerializer>

    companion object Constants {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
        const val POKEMON = "pokemon/"
        const val POKEMON_DETAIL = "pokemon/{id}/"
    }
}