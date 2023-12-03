package com.aradevs.pokeapp.ui.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.mockPokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.species.PokemonSpecies
import com.aradevs.pokeapp.domain.pokemon.detail.species.mockPokemonSpecies
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.domain.pokemon.list.mockPokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface PokemonDetailActions {
    fun getPokemonDetailStatus(): StateFlow<Status<PokemonDetail>>

    fun getPokemonDetail()

    fun getPokemonSpeciesStatus(): StateFlow<Status<PokemonSpecies>>

    fun getPokemonSpecies()

    fun getCurrentPokemon(): MutableState<Pokemon?>

    fun onBackButtonPressed()

    fun openWiki(pokemonName: String)
}

object MockPokemonDetailActions : PokemonDetailActions {
    override fun getPokemonDetailStatus(): StateFlow<Status<PokemonDetail>> {
        return MutableStateFlow(Status.Success(mockPokemonDetail))
    }

    override fun getPokemonDetail() {
        // no-op
    }

    override fun getPokemonSpeciesStatus(): StateFlow<Status<PokemonSpecies>> {
        return MutableStateFlow(Status.Success(mockPokemonSpecies))
    }

    override fun getPokemonSpecies() {
        //no-op
    }

    override fun onBackButtonPressed() {
        //no-op
    }

    override fun openWiki(pokemonName: String) {
        //no-op
    }

    override fun getCurrentPokemon(): MutableState<Pokemon?> {
        return mutableStateOf(mockPokemon)
    }

}