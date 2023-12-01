package com.aradevs.pokeapp.usecases.utils

import android.util.Log
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import java.lang.NumberFormatException

const val POKEMON_URL_ID_OFFSET = 2
const val FIRST_GEN_POKEMON_COUNT = 151
const val POKEMON_PER_PAGE = 10

/* Check the pokemon list and returns only the first 151 pokemon, this will limit the last
   page since 151 is a prime number and some overflow will occur in the last page
 */
fun List<Pokemon>.limitFirstGenPokemon(): List<Pokemon> {
    return this.filter { pokemon ->

        if (pokemon.url.isEmpty()) return@filter false

        val pokemonId: String = pokemon.url.split("/").run {
            this[this.size - POKEMON_URL_ID_OFFSET]
        }

        try {
            pokemonId.toInt() <= FIRST_GEN_POKEMON_COUNT
        } catch (nfe: NumberFormatException) {
            Log.e("Pokemon first region limiter exception", nfe.toString())
            false
        }

    }
}