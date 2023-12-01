package com.aradevs.pokeapp.usecases

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aradevs.pokeapp.data.repository.PokemonRepository
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.usecases.utils.FIRST_GEN_POKEMON_COUNT
import com.aradevs.pokeapp.usecases.utils.POKEMON_PER_PAGE
import com.aradevs.pokeapp.usecases.utils.limitFirstGenPokemon

class FetchPokemonUseCase(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke() = object : PagingSource<Int, Pokemon>() {

        override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                val anchorPage = state.closestPageToPosition(anchorPosition)
                anchorPage?.prevKey?.plus(POKEMON_PER_PAGE) ?: anchorPage?.nextKey?.minus(
                    POKEMON_PER_PAGE
                )
            }
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
            return try {
                val nextPageNumber = params.key ?: POKEMON_PER_PAGE
                val nextPage = params.key ?: 0

                return when (val result =
                    pokemonRepository.getPokemon(offset = nextPage, limit = POKEMON_PER_PAGE)) {

                    is Status.Success -> LoadResult.Page(
                        data = result.data.results.limitFirstGenPokemon(),
                        prevKey = if (nextPageNumber == 0) null else nextPageNumber.minus(
                            POKEMON_PER_PAGE
                        ),
                        nextKey = if (nextPageNumber < FIRST_GEN_POKEMON_COUNT) nextPageNumber.plus(
                            POKEMON_PER_PAGE
                        ) else null
                    )

                    else -> LoadResult.Error((result as Status.Error).exception)

                }
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }
}