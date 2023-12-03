package com.aradevs.pokeapp.utils

import android.content.Context
import android.content.Intent
import com.aradevs.pokeapp.ui.detail.PokemonDetailActivity

const val POKEMON_ID = "pokemonId"
const val POKEMON_NAME = "pokemonName"

/**
 * Open new pokemon detail activity
 * @param pokemonId [Int] the pokemon id
 * @param pokemonName [String] the pokemon name
 */
fun Context.openNewPokemonDetailActivity(pokemonId: Int, pokemonName: String) {
    val intent = Intent(this, PokemonDetailActivity::class.java)
        .apply {
            putExtra(POKEMON_ID, pokemonId)
            putExtra(POKEMON_NAME, pokemonName)
        }
    startActivity(intent)
}