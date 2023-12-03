package com.aradevs.pokeapp.ui.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.obtainPokemonUrl
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.species.PokemonSpecies
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.usecases.GetPokemonDetailUseCase
import com.aradevs.pokeapp.usecases.GetPokemonSpeciesUseCase
import com.aradevs.safe.safeInt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailActivityViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    private val getPokemonSpeciesUseCase: GetPokemonSpeciesUseCase,
) : ViewModel() {

    private val _pokemonDetail: MutableStateFlow<Status<PokemonDetail>> =
        MutableStateFlow(Status.Initial())
    val pokemonDetail: StateFlow<Status<PokemonDetail>> = _pokemonDetail

    private val _pokemonSpecies: MutableStateFlow<Status<PokemonSpecies>> =
        MutableStateFlow(Status.Initial())
    val pokemonSpecies: StateFlow<Status<PokemonSpecies>> = _pokemonSpecies

    var currentPokemon: MutableState<Pokemon?> = mutableStateOf(null)
        private set

    fun getPokemonDetail() {
        if (currentPokemon.value == null) return
        viewModelScope.launch(Dispatchers.IO) {
            _pokemonDetail.emit(Status.Loading())
            getPokemonDetailUseCase(currentPokemon.value?.id.toString()).collect {
                _pokemonDetail.emit(it)
            }
        }
    }

    fun getPokemonSpecies() {
        if (currentPokemon.value == null) return
        viewModelScope.launch(Dispatchers.IO) {
            _pokemonSpecies.emit(Status.Loading())
            getPokemonSpeciesUseCase(currentPokemon.value?.id.safeInt()).collect {
                _pokemonSpecies.emit(it)
            }
        }
    }

    fun setCurrentPokemon(pokemonId: Int, pokemonName: String) {
        currentPokemon.value = Pokemon(
            id = pokemonId,
            name = pokemonName,
            url = obtainPokemonUrl(pokemonId)
        )
    }

}