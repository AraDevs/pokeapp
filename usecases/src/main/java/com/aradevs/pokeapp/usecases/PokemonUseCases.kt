package com.aradevs.pokeapp.usecases

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aradevs.pokeapp.data.repository.PokemonRepository
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.domain.FIRST_GEN_POKEMON_COUNT
import com.aradevs.pokeapp.domain.POKEMON_PER_PAGE
import com.aradevs.pokeapp.domain.limitFirstGenPokemon
import com.aradevs.pokeapp.domain.setIdAndImage

class FetchPokemonUseCase(
    private val pokemonRepository: PokemonRepository
) {
    /**
     * Get pokemon list from api
     * @return LoadResult<Int, Pokemon>
     */
    operator fun invoke() = object : PagingSource<Int, Pokemon>() {

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
                val nextPage = params.key ?: 0

                return when (val result =
                    pokemonRepository.getPokemon(offset = nextPage, limit = POKEMON_PER_PAGE)) {

                    is Status.Success -> LoadResult.Page(
                        data = result.data.results
                            .limitFirstGenPokemon()
                            .setIdAndImage(),
                        prevKey = if (nextPage <= 0) null else nextPage.minus(
                            POKEMON_PER_PAGE
                        ),
                        nextKey = if (nextPage < FIRST_GEN_POKEMON_COUNT) nextPage.plus(
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

class GetPokemonDetailUseCase(private val pokemonRepository: PokemonRepository) {
    /**
     * Get pokemon detail from api
     * @param identifier String pokemon identifier
     * @return Flow<Status<PokemonDetail>>
     */
    operator fun invoke(identifier: String) = pokemonRepository.getPokemonDetail(identifier)
}

class GetPokemonSpeciesUseCase(private val pokemonRepository: PokemonRepository) {
    /**
     * Get pokemon species from api
     * @param id Int pokemon id
     * @return Flow<Status<PokemonSpecies>>
     */
    operator fun invoke(id: Int) = pokemonRepository.getPokemonSpecies(id)
}