package com.aradevs.pokeapp

import androidx.compose.runtime.Composable
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.domain.pokemon.list.mockPokemon
import kotlinx.coroutines.flow.flowOf

interface PokemonActions {
    @Composable
    fun getPokemonList(): LazyPagingItems<Pokemon>
}

object MockPokemonActions : PokemonActions {
    @Composable
    override fun getPokemonList(): LazyPagingItems<Pokemon> {
        return flowOf(PagingData.from(listOf(mockPokemon))).collectAsLazyPagingItems()
    }
}