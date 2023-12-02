package com.aradevs.pokeapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.usecases.FetchPokemonUseCase
import com.aradevs.pokeapp.usecases.utils.POKEMON_PER_PAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val fetchPokemonListUseCase: FetchPokemonUseCase,
) : ViewModel() {
    var pokemonList: Flow<PagingData<Pokemon>> = Pager(
        config = PagingConfig(
            pageSize = POKEMON_PER_PAGE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { fetchPokemonListUseCase() }
    ).flow.cachedIn(viewModelScope)
        private set
}