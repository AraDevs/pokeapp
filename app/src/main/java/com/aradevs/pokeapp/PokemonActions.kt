package com.aradevs.pokeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.mockPokemonDetail
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.domain.pokemon.list.mockPokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf

interface PokemonActions {
    @Composable
    fun getPokemonList(): LazyPagingItems<Pokemon>

    fun getCurrentPokemonDetail(): StateFlow<Status<PokemonDetail>>

    fun getPokemonDetail(identifier: String)

    fun getFilterValue(): MutableState<String>

    fun updateFilterValue(newValue: String)
}

object MockPokemonActions : PokemonActions {
    @Composable
    override fun getPokemonList(): LazyPagingItems<Pokemon> {
        return flowOf(PagingData.from(listOf(mockPokemon))).collectAsLazyPagingItems()
    }

    override fun getCurrentPokemonDetail(): StateFlow<Status<PokemonDetail>> {
        return MutableStateFlow(Status.Success(mockPokemonDetail))
    }

    override fun getPokemonDetail(identifier: String) {
        // no-op
    }

    override fun getFilterValue(): MutableState<String> {
        return mutableStateOf("")
    }

    override fun updateFilterValue(newValue: String) {
        // no-op
    }
}