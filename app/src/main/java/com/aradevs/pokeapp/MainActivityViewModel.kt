package com.aradevs.pokeapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.usecases.FetchPokemonUseCase
import com.aradevs.pokeapp.usecases.GetPokemonDetailUseCase
import com.aradevs.pokeapp.domain.POKEMON_PER_PAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val fetchPokemonListUseCase: FetchPokemonUseCase,
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
) : ViewModel() {
    var pokemonList: Flow<PagingData<Pokemon>> = Pager(
        config = PagingConfig(
            pageSize = POKEMON_PER_PAGE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { fetchPokemonListUseCase() }
    ).flow.cachedIn(viewModelScope)
        private set

    private val _currentPokemonDetail: MutableStateFlow<Status<PokemonDetail>> =
        MutableStateFlow(Status.Initial())
    val currentPokemonDetail: StateFlow<Status<PokemonDetail>> = _currentPokemonDetail

    var currentFilterValue: MutableState<String> = mutableStateOf("")
        private set

    fun getPokemonDetail(identifier: String = "") {
        viewModelScope.launch(Dispatchers.IO) {
            _currentPokemonDetail.emit(Status.Loading())
            getPokemonDetailUseCase(identifier.lowercase()).collectLatest {
                _currentPokemonDetail.emit(it)
            }
        }
    }

    fun updateFilterValue(newValue: String) {
        if (newValue.isBlank()) {
            viewModelScope.launch {
                _currentPokemonDetail.emit(Status.Initial())
            }
        }
        currentFilterValue.value = newValue
    }
}