package com.aradevs.pokeapp.usecases.utils

import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import java.lang.NumberFormatException

const val POKEMON_URL_ID_OFFSET = 2
const val FIRST_GEN_POKEMON_COUNT = 151
const val POKEMON_PER_PAGE = 20

/* Check the pokemon list and returns only the first 151 pokemon, this will limit the last
   page since 151 is a prime number and some overflow will occur in the last page
 */
fun List<Pokemon>.limitFirstGenPokemon(): List<Pokemon> = this.filter { pokemon ->
    if (pokemon.url.isEmpty()) return@filter false

    val pokemonId = getPokemonIdFromUrl(pokemon.url)

    pokemonId <= FIRST_GEN_POKEMON_COUNT
}

/*
    This function will set the pokemon id and image based on the url provided by the api
 */
fun List<Pokemon>.setIdAndImage(): List<Pokemon> = this.map { pokemon ->
    val pokemonId = getPokemonIdFromUrl(pokemon.url)
    pokemon.copy(id = pokemonId, image = obtainPokemonImage(pokemonId))
}

/*this is a workaround to get the pokemon image since the api doesn't provide it when obtaining a list of pokemon, however, based on research this
  url is static and should be future proof*/
fun obtainPokemonImage(id: Int): String =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/$id.png"

/*
    This function will get the pokemon id from the url provided by the api
 */
fun getPokemonIdFromUrl(url: String): Int {
    val pokemonId: String = url.split("/").run {
        this[this.size - POKEMON_URL_ID_OFFSET]
    }
    return try {
        pokemonId.toInt()
    } catch (nfe: NumberFormatException) {
        0
    }
}